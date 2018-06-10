package com.osaat.mymovies

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("discover/movie")
    fun getPopularMovies(@Query("language") language: String, @Query("sort_by") sortBy: String, @Query("api_key") apiKey: String):
            Observable<MovieResponse>
}
