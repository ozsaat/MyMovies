package com.osaat.mymovies

import com.google.gson.annotations.SerializedName

class MovieListResult {

    @SerializedName("results")
    lateinit var movies: List<Movie>
}