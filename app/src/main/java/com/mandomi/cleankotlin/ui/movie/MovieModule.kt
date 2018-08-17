package com.mandomi.cleankotlin.ui.movie

import androidx.lifecycle.ViewModel
import com.mandomi.cleankotlin.di.annotation.ViewModelKey
import com.mandomi.cleankotlin.ui.movie.moviedetail.MovieDetailFragment
import com.mandomi.cleankotlin.ui.movie.moviedetail.MovieDetailViewModel
import com.mandomi.cleankotlin.ui.movie.movies.MoviesFragment
import com.mandomi.cleankotlin.ui.movie.movies.MoviesViewModel
import com.mandomi.data.datasource.movie.MovieRemoteDataSource
import com.mandomi.data.repository.MovieRepositoryImpl
import com.mandomi.domain.repository.MovieRepository
import com.mandomi.remote.datasource.MovieRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MovieModule {

    @ContributesAndroidInjector
    internal abstract fun moviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    internal abstract fun movieDetailFragment(): MovieDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindsMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindsMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel

    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}