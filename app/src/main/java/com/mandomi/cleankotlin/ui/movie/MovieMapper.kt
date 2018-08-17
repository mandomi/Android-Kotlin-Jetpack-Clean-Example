package com.mandomi.cleankotlin.ui.movie

import com.mandomi.domain.entity.Genre
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.mapper.DataMapper
import javax.inject.Inject

class MovieMapper @Inject constructor() : DataMapper<Movie, MovieItem>() {
    override fun apply(t: Movie): MovieItem {
        return MovieItem(t.id, t.name, t.description, t.posterUrl, t.coverUrl, parseGenres(t.genres), t.homePage, t.language, t.releaseDate)
    }

    private fun parseGenres(genres: List<Genre>?): String? {
        val map = genres?.map { it.name }
        return if (map != null) {
            var items = ""
            for (item in map) {
                items += "$item, "
            }
            items
        } else null
    }
}