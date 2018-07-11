package com.osaat.mymovies

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val apiKey: String = BuildConfig.ApiKey

    private val client by lazy { MovieAPI.create() }
    private lateinit var movieAdapter: MovieAdapter

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setupRecycler()

        showMovies()

    }

    private fun showMovies() {

        disposable = client.getPopularMovies("en", "popularity.desc", apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> movieAdapter.setData(result) },
                        {e -> onGetMoviesFailure(e)}
                )

    }


    private fun onGetMoviesFailure(e: Throwable?) {
        Log.e(e?.message, e?.stackTrace.toString())
    }

    private fun setupRecycler() {
        movieAdapter = MovieAdapter()
        movieRecycler.setHasFixedSize(true)
        val layoutManager =  GridLayoutManager(this, 2)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        movieRecycler.layoutManager = layoutManager
        movieRecycler.adapter = movieAdapter
        movieRecycler.addOnItemTouchListener(CustomRecyclerViewItemTouchListener(movieRecycler, intArrayOf(R.id.moviePoster),
                object : CustomRecyclerViewItemTouchListener.MyCustomClickListener {
                    override fun onLongClick(view: View, position: Int) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onClick(view: View, position: Int) {
                        Toast.makeText(view.context, "Single click action on position = " + position, Toast.LENGTH_LONG).show()
                    }
                }))

    }

}
