package com.mandomi.domain.entity

data class Movie(val id: Int, val name: String, val description: String,
                 val posterUrl: String, val coverUrl: String, val genres: List<Genre>?,
                 val homePage: String?, val language: String, val releaseDate: String)

data class Genre(val id: Int, val name: String)