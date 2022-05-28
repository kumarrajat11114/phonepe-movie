package com.rajat.phonepemovie.movies.domain.usecase

import com.rajat.phonepemovie.common.ErrorMapper
import com.rajat.phonepemovie.common.NetworkResource
import com.rajat.phonepemovie.common.Resource
import com.rajat.phonepemovie.movies.data.MoviesRepo
import com.rajat.phonepemovie.movies.domain.mapper.MoviesMapper
import com.rajat.phonepemovie.movies.domain.model.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetMoviesUseCase(
    private val moviesMapper: MoviesMapper,
    private val moviesRepo: MoviesRepo
) {
    suspend fun execute() = flow<Resource<Movies>> {
        emit(Resource.Loading())
        moviesRepo.getMovies().collect { resource ->
            when (resource) {
                is NetworkResource.Error -> emit(Resource.Error(
                    ErrorMapper.map(resource.throwable)
                ))
                is NetworkResource.Success -> emit(Resource.Success(
                    moviesMapper.map(resource.data)
                ))
            }
        }
    }.flowOn(Dispatchers.Main)
}