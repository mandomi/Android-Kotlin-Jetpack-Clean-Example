package com.mandomi.domain.interactor.base

import com.mandomi.cleankotlin.domain.executer.PostExecutionThread
import com.mandomi.cleankotlin.domain.executer.UseCaseExecutor
import com.mandomi.domain.observer.SingleObserver
import io.reactivex.Single
import io.reactivex.annotations.CheckReturnValue

abstract class SingleUseCase<Result, in Params> constructor(
        private val useCaseExecutor: UseCaseExecutor,
        private val postExecutionThread: PostExecutionThread
) : UseCase() {

    protected abstract fun buildSingle(params: Params): Single<Result>

    @CheckReturnValue
    fun execute(
            params: Params,
            success: (result: Result) -> Unit,
            error: (e: Throwable) -> Unit
    ): SingleUseCase<Result, Params> {
        val observable = this.buildSingle(params)
                .subscribeOn(useCaseExecutor.scheduler)
                .observeOn(postExecutionThread.scheduler)

        addDisposable(observable.subscribeWith(SingleObserver(success, error)))
        return this
    }
}
