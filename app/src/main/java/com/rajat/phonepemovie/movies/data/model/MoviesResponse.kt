package com.rajat.phonepemovie.movies.data.model

data class MoviesResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>
)

data class Dates(
    val maximum: String?,
    val minimum: String?
)

data class Result(
    val adult: String?,
    val backdrop_path: String?,
    val genre_ids: List<Int>?,
    val id: Int,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: String?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean,
    val vote_average: Float,
    val vote_count: Int

)
