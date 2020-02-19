package com.example.dagger.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object TimePassModule {

    @Provides
    @JvmStatic
    fun getData(): String {
        return "hello"
    }
}