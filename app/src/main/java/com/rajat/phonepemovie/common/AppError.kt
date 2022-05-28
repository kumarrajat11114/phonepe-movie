package com.rajat.phonepemovie.common

sealed class AppError(
    val title: String,
    val subTitle: String,
) {
    object NetworkError: AppError(
        title = "You Seems to be offline",
        subTitle = "Please check you internet connection"
    )

    object ServerError: AppError(
        title = "Something Went Wrong!",
        subTitle = "Something is wrong with our servers. Please try again later."
    )
}
