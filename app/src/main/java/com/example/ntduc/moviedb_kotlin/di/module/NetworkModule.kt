package com.example.ntduc.moviedb_kotlin.di.module

import com.example.ntduc.moviedb_kotlin.BuildConfig
import com.example.ntduc.moviedb_kotlin.data.source.remote.api.MovieApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClientBuilder(): OkHttpClient.Builder =
            OkHttpClient.Builder()
                    .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)

    @Provides
    @Singleton
    @Named(MOVIE_DB_NAME)
    fun provideMovieOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient =
            builder.addInterceptor { chain ->
                var request = chain.request()
                val url = request
                        .url()
                        .newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY)
                        .build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            }.build()

    @Provides
    @Singleton
    @Named(MOVIE_DB_NAME)
    fun provideMovieRetrofitBuilder(@Named(MOVIE_DB_NAME) okHttpClient: OkHttpClient): Retrofit.Builder =
            Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    @Provides
    @Named(MOVIE_DB_NAME)
    fun provideMovieRetrofit(@Named(MOVIE_DB_NAME) builder: Retrofit.Builder): Retrofit =
            builder.baseUrl(MovieApi.BASE_URL).build()

    @Provides
    @Singleton
    fun provideMovieApi(@Named(MOVIE_DB_NAME) retrofit: Retrofit): MovieApi =
            retrofit.create(MovieApi::class.java)
    companion object {
        const val CONNECTION_TIMEOUT = 10L
        const val READ_TIMEOUT = 10L
        const val WRITE_TIMEOUT = 10L
        const val MOVIE_DB_NAME = "movie_db"
    }
}
