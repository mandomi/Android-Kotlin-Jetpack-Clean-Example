package com.mandomi.cleankotlin.ui.movie

data class MovieItem(val id: Int, val name: String, val description: String,
                     val posterUrl: String, val coverUrl: String, val genres: String?,
                     val homePage: String?, val language: String, val releaseDate: String)