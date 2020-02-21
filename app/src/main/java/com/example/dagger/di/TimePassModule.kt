package com.example.dagger.di

import dagger.Module
import dagger.Provides

// Test class for basic dependency injection
@Module
object TimePassModule {

    @Provides
    @JvmStatic
    fun getData(): String {
        return "hello"
    }
}