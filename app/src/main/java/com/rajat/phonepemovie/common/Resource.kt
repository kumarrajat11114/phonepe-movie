package com.rajat.phonepemovie.common

sealed class Resource<T> {
    data class Loading<T>(val msg: String = ""): Resource<T>()
    data class Success<T>(val data: T): Resource<T>()
    data class Error<T>(val error: AppError): Resource<T>()
}