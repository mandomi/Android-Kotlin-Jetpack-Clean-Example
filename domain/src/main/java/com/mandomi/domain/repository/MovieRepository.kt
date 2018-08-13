package com.mandomi.domain.repository

import com.mandomi.domain.entity.Movie
import io.reactivex.Single

interface MovieRepository {
    fun getMovies(): Single<List<Movie>>
}