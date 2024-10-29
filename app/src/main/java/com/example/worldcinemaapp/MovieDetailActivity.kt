package com.example.worldcinemaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieTitle = intent.getStringExtra("movie_title") ?: "Название фильма"
        val movieImageResId = intent.getIntExtra("movie_image", R.drawable.magicians)
        val movieDescription = "Здесь будет описание фильма. Это демонстрационный текст для приложения."

        val titleTextView: TextView = findViewById(R.id.movieTitleTextView)
        val movieImageView: ImageView = findViewById(R.id.movieImageView)
        val descriptionTextView: TextView = findViewById(R.id.movieDescriptionTextView)
        val framesRecyclerView: RecyclerView = findViewById(R.id.framesRecyclerView)
        val movieImage: ImageView = findViewById(R.id.movieImage)
        val backBtn: ImageButton = findViewById(R.id.back_btn)

        titleTextView.text = movieTitle
        movieImageView.setImageResource(movieImageResId)
        movieImage.setImageResource(movieImageResId)
        descriptionTextView.text = movieDescription

        backBtn.setOnClickListener { finish() }

        framesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        framesRecyclerView.adapter = FramesAdapter(getSampleFrames())

    }

    private fun getSampleFrames(): List<Int> {
        return listOf(
            R.drawable.altered_carbon,
            R.drawable.altered_carbon,
            R.drawable.altered_carbon,
            R.drawable.altered_carbon,
            R.drawable.altered_carbon
        )
    }
}
