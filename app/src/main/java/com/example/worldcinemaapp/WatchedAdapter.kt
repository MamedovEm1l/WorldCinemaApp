package com.example.worldcinemaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class WatchedAdapter(
    private val watchedMovies: List<Movie>,
    private val onClick: (Movie) -> Unit
) : RecyclerView.Adapter<WatchedAdapter.WatchedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_watched_movie, parent, false)
        return WatchedViewHolder(view)
    }

    override fun onBindViewHolder(holder: WatchedViewHolder, position: Int) {
        holder.bind(watchedMovies[position], onClick)
    }

    override fun getItemCount(): Int = watchedMovies.size

    class WatchedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieImageView: ImageView = itemView.findViewById(R.id.movieImageView)

        fun bind(movie: Movie, onClick: (Movie) -> Unit) {
            movieImageView.setImageResource(movie.imageResId)
            itemView.setOnClickListener { onClick(movie) }
        }
    }
}
