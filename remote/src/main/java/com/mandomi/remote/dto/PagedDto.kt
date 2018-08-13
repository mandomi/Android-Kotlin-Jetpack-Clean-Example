package com.mandomi.remote.dto

import com.google.gson.annotations.SerializedName

data class PagedDto<T>(@SerializedName("page") val page: Int,
                       @SerializedName("total_results") val totalResults: Int,
                       @SerializedName("total_pages") val totalPages: Int,
                       @SerializedName("results") val items: List<T>)