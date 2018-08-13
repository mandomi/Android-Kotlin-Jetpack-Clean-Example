package com.mandomi.domain.entity

data class PagedEntity<T>(val page: Int, val totalResults: Int, val totalPages: Int, val items: List<T>)