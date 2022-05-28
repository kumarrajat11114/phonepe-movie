package com.rajat.phonepemovie.movies.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rajat.phonepemovie.movies.data.model.MoviesResponse
import java.io.InputStreamReader

class MoviesNetworkService {
    fun getMovies(): MoviesResponse {
        return Gson().fromJson(
            InputStreamReader(MoviesResponse::class.java.classLoader!!
                .getResourceAsStream("movies.json")
            ), object : TypeToken<MoviesResponse>() {}.type
        )
    }
}