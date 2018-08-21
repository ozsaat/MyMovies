package com.osaat.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.movie_row.view.*


class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "movie_details"
    }

    private lateinit var backdropImage: ImageView
    private lateinit var overview: TextView
    private lateinit var rating: TextView
    private lateinit var releaseDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent
        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        backdropImage = movieBackDrop
        releaseDate = movieReleaseDate
        overview = movieOverview
        rating = movieRating

        Picasso.get().load("http://image.tmdb.org/t/p/w342/${movie.backdropPath}")
                .into(backdropImage)
        releaseDate.text = movie.releaseDate
        rating.text = movie.voteAverage.toString()
        overview.text = movie.overview

    }
}
