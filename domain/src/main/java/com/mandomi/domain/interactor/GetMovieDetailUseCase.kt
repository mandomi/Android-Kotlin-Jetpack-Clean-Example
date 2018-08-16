package com.mandomi.domain.interactor

import com.mandomi.cleankotlin.domain.executer.PostExecutionThread
import com.mandomi.cleankotlin.domain.executer.UseCaseExecutor
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.interactor.base.SingleUseCase
import com.mandomi.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
        private val movieRepository: MovieRepository,
        useCaseExecutor: UseCaseExecutor,
        postExecutionThread: PostExecutionThread) :
        SingleUseCase<Movie, GetMovieDetailUseCase.Params>(useCaseExecutor, postExecutionThread) {

    override fun buildSingle(params: Params): Single<Movie> {
        return movieRepository.getMovieDetail(params.movieId)
    }

    class Params(val movieId: Int)
}
