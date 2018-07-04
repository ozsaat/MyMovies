package com.osaat.mymovies

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("id") val id: Int,
        @SerializedName("vote_average") val voteAverage: Double,
        @SerializedName("title") val title: String,
        @SerializedName("popularity") val popularity: Double,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String
)

data class MovieResponse(
        @SerializedName("page") val page: Int,
        @SerializedName("results") val list: List<Movie>) {
}