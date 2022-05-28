package com.rajat.phonepemovie.movies.domain.model

data class Movies(
    val movies: List<Movie>
) {
    companion object {
        fun EMPTY() = Movies(
            listOf(
                Movie("", "", "")
            )
        )
    }
}


data class Movie(
    val imgUrl: String,
    val title: String,
    val description: String
)
