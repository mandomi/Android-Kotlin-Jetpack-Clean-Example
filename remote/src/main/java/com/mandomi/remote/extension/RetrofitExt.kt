package com.mandomi.remote.extension

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.exceptions.CompositeException
import io.reactivex.exceptions.Exceptions
import io.reactivex.plugins.RxJavaPlugins
import retrofit2.Call
import retrofit2.HttpException

fun <T> Call<T>.toRxObservable(): Observable<T> = BodyObservable(RetrofitCallObservable(this))
fun <T> Call<T>.toRxSingle(): Single<T> = toRxObservable().singleOrError()

fun <T> Call<T>.fetchBody(): T {
    return execute().let {
        if (!it.isSuccessful) throw HttpException(it)
        it.body()!!
    }
}

private class RetrofitCallObservable<T>(private val originalCall: Call<T>) : Observable<retrofit2.Response<T>>() {

    override fun subscribeActual(observer: Observer<in retrofit2.Response<T>>) {
        // Since Call is a one-shot type, clone it for each new observer.
        val call = originalCall.clone()
        observer.onSubscribe(CallDisposable(call))

        var terminated = false
        try {
            val response = call.execute()
            if (!call.isCanceled) {
                observer.onNext(response)
            }
            if (!call.isCanceled) {
                terminated = true
                observer.onComplete()
            }
        } catch (t: Throwable) {
            Exceptions.throwIfFatal(t)
            if (terminated) {
                RxJavaPlugins.onError(t)
            } else if (!call.isCanceled) {
                try {
                    observer.onError(t)
                } catch (inner: Throwable) {
                    Exceptions.throwIfFatal(inner)
                    RxJavaPlugins.onError(CompositeException(t, inner))
                }
            }
        }
    }
}

private class CallDisposable(private val call: Call<*>) : Disposable {
    override fun dispose() {
        call.cancel()
    }

    override fun isDisposed(): Boolean {
        return call.isCanceled
    }
}

private class BodyObservable<T>(private val upstream: Observable<retrofit2.Response<T>>) : Observable<T>() {
    override fun subscribeActual(observer: Observer<in T>) {
        upstream.subscribe(BodyObserver(observer))
    }
}

private class BodyObserver<R>(private val observer: Observer<in R>) : Observer<retrofit2.Response<R>> {
    private var terminated: Boolean = false

    override fun onSubscribe(disposable: Disposable) {
        observer.onSubscribe(disposable)
    }

    override fun onNext(response: retrofit2.Response<R>) {
        if (response.isSuccessful) {
            observer.onNext(response.body()!!)
        } else {
            terminated = true
            val t = retrofit2.HttpException(response)
            try {
                observer.onError(t)
            } catch (inner: Throwable) {
                Exceptions.throwIfFatal(inner)
                RxJavaPlugins.onError(CompositeException(t, inner))
            }
        }
    }

    override fun onComplete() {
        if (!terminated) {
            observer.onComplete()
        }
    }

    override fun onError(throwable: Throwable) {
        if (!terminated) {
            observer.onError(throwable)
        } else {
            // This should never happen! onNext handles and forwards errors automatically.
            val broken = AssertionError(
                    "This should never happen! Report as a bug with the full stacktrace."
            )

            broken.initCause(throwable)
            RxJavaPlugins.onError(broken)
        }
    }
}