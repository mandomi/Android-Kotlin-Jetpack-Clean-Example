package com.mandomi.remote.mapper

import com.mandomi.data.entity.MovieEntity
import com.mandomi.remote.dto.MovieDto
import javax.inject.Inject

class PagedMovieEntityDataMapper @Inject constructor(itemDataMapper: MovieEntityDataMapper) :
        PagedEntityMapper<MovieDto, MovieEntity>(itemDataMapper)