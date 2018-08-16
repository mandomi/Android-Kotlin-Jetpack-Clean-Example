package com.mandomi.data.mapper

import com.mandomi.data.entity.MovieEntity
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.mapper.DataMapper
import javax.inject.Inject

class MovieEntityMapper @Inject constructor() : DataMapper<MovieEntity, Movie>() {
    override fun apply(t: MovieEntity): Movie {
        return Movie(t.id, t.name, t.description, t.imageUrl,
                t.genres, t.homePage, t.language, t.releaseDate)
    }
}