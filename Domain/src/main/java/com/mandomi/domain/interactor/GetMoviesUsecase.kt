package com.mandomi.domain.interactor

import com.farsitel.bazaar.domain.executer.PostExecutionThread
import com.farsitel.bazaar.domain.executer.UseCaseExecutor
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.entity.None
import com.mandomi.domain.entity.PagedEntity
import com.mandomi.domain.interactor.base.SingleUseCase
import com.mandomi.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMoviesUsecase @Inject constructor(
        private val movieRepository: MovieRepository,
        useCaseExecutor: UseCaseExecutor,
        postExecutionThread: PostExecutionThread) : SingleUseCase<PagedEntity<Movie>,
        None>(useCaseExecutor, postExecutionThread) {

    override fun buildSingle(params: None): Single<PagedEntity<Movie>> {
        return movieRepository.getMovies()
    }
}