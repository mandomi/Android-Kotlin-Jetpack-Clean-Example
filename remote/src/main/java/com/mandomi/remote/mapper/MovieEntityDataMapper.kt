package com.mandomi.remote.mapper

import com.mandomi.data.entity.MovieEntity
import com.mandomi.domain.mapper.DataMapper
import com.mandomi.remote.RemoteConstants.Companion.COVER_IMAGE_URL_PREFIX
import com.mandomi.remote.RemoteConstants.Companion.POSTER_IMAGE_URL_PREFIX
import com.mandomi.remote.dto.MovieDto
import javax.inject.Inject

class MovieEntityDataMapper @Inject constructor() : DataMapper<MovieDto, MovieEntity>() {
    override fun apply(t: MovieDto): MovieEntity {
        return MovieEntity(t.id, t.name, t.description, POSTER_IMAGE_URL_PREFIX + t.posterToken,
                COVER_IMAGE_URL_PREFIX + t.coverToken, t.genres, t.homePage, t.language, t.releaseDate)
    }
}