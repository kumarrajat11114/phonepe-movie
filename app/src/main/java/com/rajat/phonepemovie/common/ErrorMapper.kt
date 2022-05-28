package com.rajat.phonepemovie.common

import java.io.IOException

object ErrorMapper {
    fun map(throwable: Throwable): AppError {
        return when(throwable) {
            is IOException ->  AppError.NetworkError
            else -> AppError.ServerError
        }
    }
}