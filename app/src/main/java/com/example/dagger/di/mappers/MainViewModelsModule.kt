package com.example.dagger.di.mappers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger.ui.main.DetailViewModel
import com.example.dagger.utils.ViewModelKey
import com.example.dagger.ui.main.MainViewModel
import com.example.dagger.utils.ViewModelProviderFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


// Default template for passing data to view models will be used in Factory pattern
@Module
abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun provideDetailViewModel(detailViewModel: DetailViewModel) : ViewModel

}