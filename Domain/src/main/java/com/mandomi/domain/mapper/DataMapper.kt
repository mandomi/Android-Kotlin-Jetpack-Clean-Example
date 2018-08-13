package com.mandomi.domain.mapper

import com.mandomi.domain.entity.PagedEntity
import io.reactivex.functions.Function

abstract class DataMapper<T, R> : Function<T, R> {

    fun apply(items: List<T>): List<R> {
        return items.map { apply(it) }
    }

    fun apply(pagedEntity: PagedEntity<T>): PagedEntity<R> {
        return PagedEntity(pagedEntity.page, pagedEntity.totalResults,
                pagedEntity.totalPages, pagedEntity.items.map { apply(it) })
    }
}
