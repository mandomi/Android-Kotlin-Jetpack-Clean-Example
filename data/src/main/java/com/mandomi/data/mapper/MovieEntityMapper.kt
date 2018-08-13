package com.mandomi.data.mapper

import com.mandomi.data.entity.MovieEntity
import com.mandomi.domain.entity.Movie
import com.mandomi.domain.mapper.DataMapper

class MovieEntityMapper : DataMapper<MovieEntity, Movie>() {
    override fun apply(t: MovieEntity): Movie {
        return Movie(t.id, t.name, t.imageUrl)
    }
}