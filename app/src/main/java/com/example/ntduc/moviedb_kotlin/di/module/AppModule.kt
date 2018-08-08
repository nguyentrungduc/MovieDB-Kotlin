package com.example.ntduc.moviedb_kotlin.di.module

import android.app.Application
import android.content.Context
import com.example.ntduc.moviedb_kotlin.rx.AppSchedulerProvider
import com.example.ntduc.moviedb_kotlin.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideContext(context: Application): Context = context

    @Singleton
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}
