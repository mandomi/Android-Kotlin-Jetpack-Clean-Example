package com.mandomi.remote.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(@SerializedName("id") val id: Int
                    , @SerializedName("title") val name: String
                    , @SerializedName("poster_path") val imageToken: String)