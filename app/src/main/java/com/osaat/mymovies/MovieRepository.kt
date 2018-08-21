package com.osaat.mymovies

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.reactivex.schedulers.Schedulers

class MovieRepository (private val movieApiService: MovieApiService) {


    private val apiKey: String = "bf06c213984ef349e1b70856ae7c1147"
    private lateinit var movieAdapter: MovieAdapter

    fun getPopularMovies(): MutableLiveData<List<Movie>> {
        val newData = MutableLiveData<List<Movie>>()
        movieApiService.getPopularMovies("en", "popularity.desc", apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .subscribe(
                { result -> movieAdapter.setData(result) },
                { e -> onGetMoviesFailure(e) }
        )


        return newData
    }

    private fun onGetMoviesFailure(e: Throwable?) {
        Log.e(e?.message, e?.stackTrace.toString())
    }
}