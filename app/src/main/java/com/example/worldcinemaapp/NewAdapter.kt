package com.example.worldcinemaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class NewAdapter(
    private val newMovies: List<Movie>,
    private val onClick: (Movie) -> Unit
) : RecyclerView.Adapter<NewAdapter.NewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_new_movie, parent, false)
        return NewViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.bind(newMovies[position], onClick)
    }

    override fun getItemCount(): Int = newMovies.size

    class NewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieImageView: ImageView = itemView.findViewById(R.id.movieImageView)

        fun bind(movie: Movie, onClick: (Movie) -> Unit) {
            movieImageView.setImageResource(movie.imageResId)
            itemView.setOnClickListener { onClick(movie) }
        }
    }
}
