package com.mandomi.cleankotlin.ui.movies

import com.mandomi.data.datasource.movie.MovieRemoteDataSource
import com.mandomi.data.repository.MovieRepositoryImpl
import com.mandomi.domain.repository.MovieRepository
import com.mandomi.remote.datasource.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoviesModule {

    @ContributesAndroidInjector
    internal abstract fun moviesActivity(): MoviesActivity

    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}