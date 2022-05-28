package com.rajat.phonepemovie.movies.di

import com.rajat.phonepemovie.movies.data.MoviesNetworkService
import com.rajat.phonepemovie.movies.data.MoviesRepo
import com.rajat.phonepemovie.movies.domain.mapper.MoviesMapper
import com.rajat.phonepemovie.movies.domain.usecase.GetMoviesUseCase
import com.rajat.phonepemovie.movies.ui.MoviesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesDiModule = module {
    single { MoviesNetworkService() }
    single { MoviesRepo(get()) }

    single { MoviesMapper() }

    single { GetMoviesUseCase(get(), get()) }

    viewModel { MoviesViewModel(get()) }
}