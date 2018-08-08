package com.example.ntduc.moviedb_kotlin.data.model

import com.example.ntduc.moviedb_kotlin.data.model.Movie
import com.google.gson.annotations.SerializedName

class ListResponse<Moivie> {

    @SerializedName("page")
    var page: Int = 0

    @SerializedName("total_results")
    var totalResult: Int = 0

    @SerializedName("total_pages")
    var totalPages: Int = 0

    @SerializedName("results")
    var results: List<Movie> = listOf()
}
