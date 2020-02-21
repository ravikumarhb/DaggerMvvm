package com.example.dagger.di.mappers

import androidx.lifecycle.ViewModelProvider
import com.example.dagger.utils.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

// Default template for passing data to view models will be used in Factory pattern
@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}