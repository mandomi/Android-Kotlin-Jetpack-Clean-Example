package com.mandomi.cleankotlin.executer

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import com.mandomi.cleankotlin.domain.executer.UseCaseExecutor

class ExecutorThread : UseCaseExecutor {
    override val scheduler: Scheduler
        get() = Schedulers.io()
}