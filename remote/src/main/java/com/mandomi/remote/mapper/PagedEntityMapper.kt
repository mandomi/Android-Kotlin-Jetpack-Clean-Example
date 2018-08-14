package com.mandomi.remote.mapper

import com.mandomi.domain.entity.PagedEntity
import com.mandomi.domain.mapper.DataMapper
import com.mandomi.remote.dto.PagedDto

abstract class PagedEntityMapper<T, R>(private val itemMapper: DataMapper<T, R>) : DataMapper<PagedDto<T>, PagedEntity<R>>() {
    override fun apply(t: PagedDto<T>): PagedEntity<R> {
        return PagedEntity(t.page, t.totalResults, t.totalPages, itemMapper.apply(t.items))
    }
}