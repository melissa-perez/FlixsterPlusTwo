package com.example.flixsterplustwo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class PopularMovieDetailActivity : AppCompatActivity() {
    private lateinit var backdropImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var movieOverviewTextView: TextView
    private lateinit var  movieVoteAverage: TextView
    private lateinit var  moviePopularity: TextView
    private lateinit var movieReleaseDate: TextView
    private lateinit var movieVoteCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.popular_movie_activity_detail)

        backdropImageView = findViewById(R.id.popBackdropImage)
        movieTitleTextView = findViewById(R.id.popMovieTitle)
        movieOverviewTextView = findViewById(R.id.popMovieOverview)
        moviePopularity = findViewById(R.id.popPopularity)
        movieReleaseDate = findViewById(R.id.popReleaseDate)
        movieVoteAverage = findViewById(R.id.popVoteAverage)
        movieVoteCount= findViewById(R.id.popVoteCount)

        val movie = intent.getSerializableExtra(POP_MOVIE_EXTRA) as PopularMovie

        movieTitleTextView.text = movie.title
        movieOverviewTextView.text = movie.overview
        moviePopularity.text = "Popularity: " + movie.popularity.toString()
        movieVoteCount.text = "Votes: " + movie.vote_count.toString()
        movieReleaseDate.text = "Released on: " + movie.release_date
        movieVoteAverage.text = "Rating: " + movie.vote_average.toString()

        val radius = 30

        Glide.with(this)
            .load(movie.backdropImageUrl)
            .transform(CircleCrop()).into(backdropImageView)
    }
}