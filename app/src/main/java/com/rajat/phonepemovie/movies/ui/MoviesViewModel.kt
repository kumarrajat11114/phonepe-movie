package com.rajat.phonepemovie.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajat.phonepemovie.common.Resource
import com.rajat.phonepemovie.movies.domain.model.Movies
import com.rajat.phonepemovie.movies.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MoviesViewModel(
    val getMoviesUseCase: GetMoviesUseCase
): ViewModel() {
    private val _moviesLiveData = MutableLiveData<Resource<Movies>>()
    val moviesLiveData: LiveData<Resource<Movies>>
    get() = _moviesLiveData

    fun getMovies() {
        viewModelScope.launch {
            getMoviesUseCase.execute().collect {
                _moviesLiveData.value = it
            }
        }
    }
}