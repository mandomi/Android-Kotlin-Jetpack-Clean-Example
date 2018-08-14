package com.mandomi.data.datasource.movie

import com.mandomi.data.entity.MovieEntity
import com.mandomi.domain.entity.PagedEntity
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getMovies(page: Int): Single<PagedEntity<MovieEntity>>
}