package com.osaat.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "movie_details"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

//        val bundle = intent.getBundleExtra(EXTRA_MOVIE)
//        var movie  = bundle.getParcelable(EXTRA_MOVIE) as Movie

    }
}
