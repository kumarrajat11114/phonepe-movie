package com.rajat.phonepemovie.common

import java.lang.Exception

sealed class NetworkResource<T> {
    data class Success<T>(val data: T): NetworkResource<T>()
    data class Error<T>(val throwable: Throwable): NetworkResource<T>()
}
