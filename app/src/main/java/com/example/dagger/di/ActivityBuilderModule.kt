package com.example.dagger.di

import com.example.dagger.MainActivity
import com.example.dagger.di.mappers.MainViewModelsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainViewModelsModule::class, FragmentBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

}