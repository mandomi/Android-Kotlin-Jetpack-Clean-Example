package com.mandomi.domain.interactor

import com.mandomi.cleankotlin.domain.executer.PostExecutionThread
import com.mandomi.cleankotlin.domain.executer.UseCaseExecutor
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.entity.None
import com.mandomi.domain.entity.PagedEntity
import com.mandomi.domain.interactor.GetMoviesUsecase.Params
import com.mandomi.domain.interactor.base.SingleUseCase
import com.mandomi.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMoviesUsecase @Inject constructor(
        private val movieRepository: MovieRepository,
        useCaseExecutor: UseCaseExecutor,
        postExecutionThread: PostExecutionThread) : SingleUseCase<PagedEntity<Movie>,
        Params>(useCaseExecutor, postExecutionThread) {

    override fun buildSingle(params: Params): Single<PagedEntity<Movie>> {
        return movieRepository.getMovies(params.page)
    }

    class Params(val page: Int)
}