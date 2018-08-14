package com.mandomi.cleankotlin.ui.movies

import com.mandomi.domain.entity.Movie
import com.mandomi.domain.mapper.DataMapper
import javax.inject.Inject

class MovieMapper @Inject constructor() : DataMapper<Movie, MovieItem>() {
    override fun apply(t: Movie): MovieItem {
        return MovieItem(t.id, t.name, t.imageUrl)
    }
}