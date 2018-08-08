package com.example.ntduc.moviedb_kotlin.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("imdb_id")
        var imdbId: Int? = 0,
        @SerializedName("adult")
        var adult: Boolean = false,
        @SerializedName("backdrop_path")
        var backdropPath: String? = "",
        @SerializedName("poster_path")
        var posterPath: String? = "",
        @SerializedName("genres")
        var homepage: String? = "",
        @SerializedName("original_language")
        var originalLanguage: String = "",
        @SerializedName("original_title")
        var originalTitle: String = "",
        @SerializedName("overview")
        var overview: String? = "",
        @SerializedName("popularity")
        var popularity: Double = 0.0
)
