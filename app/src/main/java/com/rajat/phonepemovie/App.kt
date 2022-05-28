package com.rajat.phonepemovie

import android.app.Application
import com.rajat.phonepemovie.movies.di.moviesDiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(moviesDiModule)
        }
    }
}