package com.example.dagger.di.mappers

import androidx.lifecycle.ViewModelProvider
import com.example.dagger.utils.ViewModelProviderFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}