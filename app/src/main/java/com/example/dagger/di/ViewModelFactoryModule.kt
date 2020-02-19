package com.example.newsfeed.dagger

import androidx.lifecycle.ViewModelProvider
import com.example.newsfeed.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}