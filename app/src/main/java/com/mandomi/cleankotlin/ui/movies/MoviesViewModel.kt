package com.mandomi.cleankotlin.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mandomi.cleankotlin.ui.base.BaseViewModel
import com.mandomi.cleankotlin.ui.base.model.Resource
import com.mandomi.cleankotlin.ui.base.model.ResourceState
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.entity.PagedEntity
import com.mandomi.domain.interactor.GetMoviesUsecase
import com.mandomi.domain.interactor.GetMoviesUsecase.Params
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val getMoviesUsecase: GetMoviesUsecase,
                                          private val movieMapper: MovieMapper) : BaseViewModel() {

    private val data: MutableLiveData<Resource<List<MovieItem>>> = MutableLiveData()
    private var endOfList = false
    private var page = 1

    fun load() {
        if (!endOfList) {
            data.postValue(Resource(ResourceState.LOADING))
            useCases += getMoviesUsecase.execute(Params(page), ::success, ::error)
        }
    }

    fun getData(): LiveData<Resource<List<MovieItem>>> {
        return data
    }

    private fun error(throwable: Throwable) {
        data.postValue(Resource(ResourceState.ERROR, failure = throwable))
    }

    private fun success(pagedEntity: PagedEntity<Movie>) {
        endOfList = if (pagedEntity.page < pagedEntity.totalPages) {
            page++
            false
        } else {
            true
        }
        if (data.value?.data == null) {
            data.postValue(Resource(ResourceState.SUCCESS, movieMapper.apply(pagedEntity).items))
        } else {
            var currentData = data.value?.data!!
            currentData += movieMapper.apply(pagedEntity).items
            data.postValue(Resource(ResourceState.SUCCESS, currentData))
        }
    }
}