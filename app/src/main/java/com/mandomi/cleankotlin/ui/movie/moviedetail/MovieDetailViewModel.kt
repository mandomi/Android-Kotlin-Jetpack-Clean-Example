package com.mandomi.cleankotlin.ui.movie.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mandomi.cleankotlin.ui.base.BaseViewModel
import com.mandomi.cleankotlin.ui.base.model.Resource
import com.mandomi.cleankotlin.ui.base.model.ResourceState.ERROR
import com.mandomi.cleankotlin.ui.base.model.ResourceState.SUCCESS
import com.mandomi.cleankotlin.ui.movie.MovieItem
import com.mandomi.cleankotlin.ui.movie.MovieMapper
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.interactor.GetMovieDetailUseCase
import com.mandomi.domain.interactor.GetMovieDetailUseCase.Params
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase,
                                               private val movieMapper: MovieMapper) : BaseViewModel() {

    private val movieDetail = MutableLiveData<Resource<MovieItem>>()

    fun getData(): LiveData<Resource<MovieItem>> {
        return movieDetail
    }

    fun load(movieId: Int) {
        useCases += getMovieDetailUseCase.execute(Params(movieId), ::success, ::error)
    }

    private fun success(movie: Movie) {
        movieDetail.postValue(Resource(SUCCESS, movieMapper.apply(movie)))
    }

    private fun error(throwable: Throwable) {
        movieDetail.postValue(Resource(ERROR, failure = throwable))
    }

}