package com.mandomi.data.datasource

import com.mandomi.data.entity.MovieEntity
import io.reactivex.Single

interface MovieRemoteDataSource {
    fun getMovies(): Single<List<MovieEntity>>
}