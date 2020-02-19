package com.example.dagger.di

import android.app.Application
import com.example.dagger.main.MainViewModelsModule
import com.example.dagger.ui.main.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Component(modules = [  ActivityBuilderModule::class,
                        AndroidSupportInjectionModule::class,
                        ViewModelFactoryModule::class,
                        TimePassModule::class
                        ])
interface ApplicationComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}