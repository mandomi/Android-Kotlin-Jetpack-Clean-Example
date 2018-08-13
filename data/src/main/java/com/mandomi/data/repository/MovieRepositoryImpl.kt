package com.mandomi.data.repository

import com.mandomi.data.datasource.movie.MovieRemoteDataSource
import com.mandomi.data.mapper.MovieEntityMapper
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
        private val movieRemoteDataSource: MovieRemoteDataSource
        , private val movieEntityMapper: MovieEntityMapper) : MovieRepository {
    override fun getMovies(): Single<List<Movie>> {
        return movieRemoteDataSource.getMovies().map { movieEntityMapper.apply(it) }
    }
}