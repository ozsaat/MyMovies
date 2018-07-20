package com.osaat.mymovies

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MoviesHolder>() {

    private var dataList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder{
        return MoviesHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun setData(movies: MovieResponse) { //add boolean flag so pull to refresh runs dataList.clear but calling different page number (infinite scroll) doesn't
        dataList.clear()
        dataList.addAll(movies.list)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Movie {
        return dataList[position]
    }

    class MoviesHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie) {
            with(movie) {
                Picasso.get().load("http://image.tmdb.org/t/p/w342/$posterPath")
                        .into(itemView.moviePoster)
            }
        }

    }


}