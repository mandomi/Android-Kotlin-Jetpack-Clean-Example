package com.mandomi.data.entity

import com.mandomi.domain.entity.Genre

data class MovieEntity(val id: Int, val name: String, val description: String,
                       val imageUrl: String, val genres: List<Genre>?,
                       val homePage: String?, val language: String, val releaseDate: String)