package com.mandomi.domain.repository

import com.mandomi.domain.entity.Movie
import com.mandomi.domain.entity.PagedEntity
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(page: Int): Single<PagedEntity<Movie>>

    fun getMovieDetail(movieId: Int): Single<Movie>
}