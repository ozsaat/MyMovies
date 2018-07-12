package com.osaat.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "user_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}
