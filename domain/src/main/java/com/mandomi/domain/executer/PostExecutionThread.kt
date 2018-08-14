package com.mandomi.cleankotlin.domain.executer

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}