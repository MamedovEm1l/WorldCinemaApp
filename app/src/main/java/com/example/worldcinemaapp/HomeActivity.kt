package com.example.worldcinemaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val trendingRecyclerView: RecyclerView = findViewById(R.id.trendingRecyclerView)
        val watchedRecyclerView: RecyclerView = findViewById(R.id.watchedRecyclerView)
        val newRecyclerView: RecyclerView = findViewById(R.id.newRecyclerView)
        val forYouRecyclerView: RecyclerView = findViewById(R.id.forYouRecyclerView)
        val watchButton: Button = findViewById(R.id.watchButton)

        trendingRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        watchedRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        newRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        forYouRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val sampleMovies = listOf(
            Movie("The Magicians", R.drawable.magicians),
            Movie("Altered Carbon", R.drawable.altered_carbon),
            Movie("13 Reasons Why", R.drawable.reasons_why),
            Movie("Lucifer", R.drawable.lucifer),
            Movie("Constantine", R.drawable.constantine)
        )

        trendingRecyclerView.adapter = MovieAdapter(sampleMovies) { movie ->
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", movie.title)
            startActivity(intent)
        }
        watchedRecyclerView.adapter = WatchedAdapter(sampleMovies) { movie ->
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", movie.title)
            startActivity(intent)
        }
        newRecyclerView.adapter = NewAdapter(sampleMovies) { movie ->
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", movie.title)
            startActivity(intent)
        }
        forYouRecyclerView.adapter = MovieAdapter(sampleMovies) { movie ->
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", movie.title)
            startActivity(intent)
        }

        watchButton.setOnClickListener {
            val intent = Intent(this, MovieDetailActivity::class.java)
            intent.putExtra("movie_title", "The magician")
            startActivity(intent)
        }
    }

}
