package com.mandomi.remote.dto

import com.google.gson.annotations.SerializedName
import com.mandomi.domain.entity.Genre

data class MovieDto(@SerializedName("id") val id: Int,
                    @SerializedName("title") val name: String,
                    @SerializedName("overview") val description: String,
                    @SerializedName("poster_path") val posterToken: String,
                    @SerializedName("backdrop_path") val coverToken: String,
                    @SerializedName("genres") val genres: List<Genre>?,
                    @SerializedName("homepage") val homePage: String,
                    @SerializedName("original_language") val language: String,
                    @SerializedName("release_date") val releaseDate: String)