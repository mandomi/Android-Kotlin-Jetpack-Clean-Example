package com.farsitel.bazaar.domain.executer

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}