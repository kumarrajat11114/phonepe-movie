package com.rajat.phonepemovie.movies.data

import com.rajat.phonepemovie.common.NetworkResource
import com.rajat.phonepemovie.movies.data.model.MoviesResponse
import com.rajat.phonepemovie.movies.domain.model.Movies
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MoviesRepo(private val networkService: MoviesNetworkService) {

    fun getMovies() = flow<NetworkResource<MoviesResponse>> {
        emit(NetworkResource.Success(networkService.getMovies()))
    }
        .flowOn(Dispatchers.IO)
        .catch {
            emit(NetworkResource.Error(it)) 
        }
}