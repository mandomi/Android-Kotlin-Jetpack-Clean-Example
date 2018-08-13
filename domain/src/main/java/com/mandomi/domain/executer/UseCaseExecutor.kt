package com.farsitel.bazaar.domain.executer

import io.reactivex.Scheduler

interface UseCaseExecutor {
    val scheduler: Scheduler
}