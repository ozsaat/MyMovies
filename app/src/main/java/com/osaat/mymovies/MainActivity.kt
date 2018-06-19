package com.osaat.mymovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val apiKey: String = BuildConfig.ApiKey

    private val client by lazy {
        MovieAPI.create()
    }

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        showMovies()

    }

    private fun showMovies() {

        disposable = client.getPopularMovies("en", "popularity.desc", apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> setupRecycler(result) },
                        {e -> onGetMoviesFailure(e)}
                )

    }


    private fun onGetMoviesFailure(e: Throwable?) {
        Log.e(e?.message, e?.stackTrace.toString())
    }

    private fun setupRecycler(movieList: MovieResponse) {

        movieRecycler.setHasFixedSize(true)
        val layoutManager =  GridLayoutManager(this, 2)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        movieRecycler.layoutManager = layoutManager
        movieRecycler.adapter = MovieAdapter(movieList){
            Log.v("Movie", it.id.toString())
        }

    }

}
