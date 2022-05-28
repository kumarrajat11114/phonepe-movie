package com.rajat.phonepemovie.movies.domain.mapper

import com.rajat.phonepemovie.movies.data.model.MoviesResponse
import com.rajat.phonepemovie.movies.domain.model.Movie
import com.rajat.phonepemovie.movies.domain.model.Movies

class MoviesMapper {
    private val BASE_IMG_PATH = "https://image.tmdb.org/t/p/w500"
    fun map(response: MoviesResponse): Movies {
        val movies = response.results.map {
            Movie(
                imgUrl = "$BASE_IMG_PATH${it.poster_path}",
                title = it.title ?: "",
                description = it.overview ?: ""
            )
        }
        return Movies(movies)
    }
}