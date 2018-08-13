package com.mandomi.domain.mapper

import io.reactivex.functions.Function

abstract class DataMapper<T, R> : Function<T, R> {

    fun apply(items: List<T>): List<R> {
        return items.map { apply(it) }
    }
}
