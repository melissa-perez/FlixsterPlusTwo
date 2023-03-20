package com.example.flixsterplustwo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import org.w3c.dom.Text

private const val TAG = "TopRatedMovieDetailActivity/"


class TopRatedMovieDetailActivity : AppCompatActivity() {
    private lateinit var backdropImageView: ImageView
    private lateinit var movieTitleTextView: TextView
    private lateinit var movieOverviewTextView: TextView
    private lateinit var  movieVoteAverage: TextView
    private lateinit var  moviePopularity: TextView
    private lateinit var movieReleaseDate: TextView
    private lateinit var movieVoteCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.top_rated_movie_activity_detail)

        backdropImageView = findViewById(R.id.backdropImage)
        movieTitleTextView = findViewById(R.id.movieTitle)
        movieOverviewTextView = findViewById(R.id.movieOverview)
        moviePopularity = findViewById(R.id.popularity)
        movieReleaseDate = findViewById(R.id.releaseDate)
        movieVoteAverage = findViewById(R.id.voteAverage)
        movieVoteCount= findViewById(R.id.voteCount)

        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as TopRatedMovie

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