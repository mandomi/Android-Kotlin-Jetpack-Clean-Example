package com.mandomi.remote.retrofit

import com.mandomi.remote.dto.MovieDto
import com.mandomi.remote.dto.PagedDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun getMovies(@Query("page") page: Int, @Query("api_key") apiKey: String): Call<PagedDto<MovieDto>>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String): Call<MovieDto>
}