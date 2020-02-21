package com.example.dagger.di

import com.example.dagger.ui.main.DetailFragment
import com.example.dagger.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

// All fragments that would need injection
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment() : DetailFragment
}