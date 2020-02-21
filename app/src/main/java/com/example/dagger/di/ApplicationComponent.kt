package com.example.dagger.di

import android.app.Application
import com.example.dagger.di.mappers.ViewModelFactoryModule
import com.example.dagger.ui.main.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

// Main Dagger component specifing dependencies
@Component(
    modules = [ActivityBuilderModule::class,
        ViewModelFactoryModule::class,
        AppModule::class,
        TimePassModule::class,
        AndroidSupportInjectionModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MyApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}