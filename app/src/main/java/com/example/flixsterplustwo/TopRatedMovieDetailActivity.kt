package com.example.flixsterplustwo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "TopRatedMovieDetailActivity/"


class TopRatedMovieDetailActivity : AppCompatActivity() {
    private lateinit var backdropImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var movieOverviewTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top_rated_movie_activity_detail)

        backdropImageView = findViewById(R.id.backdropImage)
        movieTitleTextView = findViewById(R.id.movieTitle)
        movieOverviewTextView = findViewById(R.id.movieOverview)

        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as TopRatedMovie

        movieTitleTextView.text = movie.title
        movieOverviewTextView.text = movie.overview

        Glide.with(this)
            .load(movie.backdropImageUrl)
            .into(backdropImageView)
    }
}