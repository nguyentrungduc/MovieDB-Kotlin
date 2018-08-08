package com.example.ntduc.moviedb_kotlin.data.source.remote.api

import com.example.ntduc.moviedb_kotlin.data.model.Movie
import com.example.ntduc.moviedb_kotlin.data.model.ListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/popular?")
    fun getPopularMovies(@Query(PARAM_PAGE) page: Int): Single<ListResponse<Movie>>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        const val PARAM_GENRE_ID = "with_genres"
        const val PARAM_MOVIE_ID = "movie_id"
        const val PARAM_PAGE = "page"
        const val PARAM_QUERY = "query"
    }
}
