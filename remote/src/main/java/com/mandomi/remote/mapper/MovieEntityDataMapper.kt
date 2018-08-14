package com.mandomi.remote.mapper

import com.mandomi.data.entity.MovieEntity
import com.mandomi.domain.mapper.DataMapper
import com.mandomi.remote.RemoteConstants
import com.mandomi.remote.dto.MovieDto
import javax.inject.Inject

class MovieEntityDataMapper @Inject constructor() : DataMapper<MovieDto, MovieEntity>() {
    override fun apply(t: MovieDto): MovieEntity {
        return MovieEntity(t.id, t.name, RemoteConstants.IMAGE_URL_PREFIX + t.imageToken)
    }
}