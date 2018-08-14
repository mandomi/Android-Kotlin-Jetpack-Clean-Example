package com.mandomi.remote.datasource

import com.mandomi.data.datasource.movie.MovieRemoteDataSource
import com.mandomi.data.entity.MovieEntity
import com.mandomi.domain.entity.PagedEntity
import com.mandomi.remote.RemoteConstants
import com.mandomi.remote.extension.toRxSingle
import com.mandomi.remote.mapper.PagedMovieEntityDataMapper
import com.mandomi.remote.retrofit.MovieService
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(okHttpClient: OkHttpClient, private val dataMapper: PagedMovieEntityDataMapper) : MovieRemoteDataSource {

    private val service: MovieService = Retrofit.Builder().baseUrl(RemoteConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build().create(MovieService::class.java)

    override fun getMovies(page: Int): Single<PagedEntity<MovieEntity>> {
        return service.getMovies(page, RemoteConstants.API_KEY).toRxSingle().map { dataMapper.apply(it) }
    }
}
