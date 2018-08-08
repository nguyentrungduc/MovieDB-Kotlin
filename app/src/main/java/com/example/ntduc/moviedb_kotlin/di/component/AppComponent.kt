package com.example.ntduc.moviedb_kotlin.di.component

import android.app.Application
import com.example.ntduc.moviedb_kotlin.MainApplication
import com.example.ntduc.moviedb_kotlin.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (AndroidInjectionModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mainApplication: MainApplication)

}
