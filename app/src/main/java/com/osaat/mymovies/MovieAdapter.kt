package com.osaat.mymovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row.view.*

class MovieAdapter(private val response: MovieResponse, private val itemClick: (Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder{
        return MoviesHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false), itemClick)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bind(response[position])
    }

    override fun getItemCount() = response.size()

    class MoviesHolder(view: View, val itemClick: (Movie) -> Unit) : RecyclerView.ViewHolder(view) {


        fun bind(movie: Movie) {
            with(movie) {
                Picasso.get().load("http://image.tmdb.org/t/p/w185/$posterPath")
                        .resize(360, 600)
                        .into(itemView.moviePoster)

                itemView.setOnClickListener { itemClick(this) }
            }
        }

    }


}