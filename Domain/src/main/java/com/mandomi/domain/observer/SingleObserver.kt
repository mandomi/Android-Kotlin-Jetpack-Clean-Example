package com.mandomi.domain.observer

import io.reactivex.observers.DisposableSingleObserver

class SingleObserver<T>(private val success: (t: T) -> Unit, private val error: (e: Throwable) -> Unit) : DisposableSingleObserver<T>() {

    override fun onSuccess(t: T) {
        success(t)
    }

    override fun onError(e: Throwable) {
        error(e)
    }
}