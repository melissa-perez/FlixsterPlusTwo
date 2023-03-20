package com.example.flixsterplustwo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


const val POP_MOVIE_EXTRA = "POP_MOVIE_EXTRA"
private const val TAG = "PopularMovieRecyclerAdapter/"

class PopularMoviesRecyclerAdapter(
    private val context: Context,
    private val popularMovies: List<PopularMovie>
    ) : RecyclerView.Adapter<PopularMoviesRecyclerAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_popular_movie, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView),
        View.OnClickListener {
        val mMoviePoster: ImageView = mView.findViewById<View>(R.id.pop_movie_image) as ImageView
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.pop_movie_title) as TextView
        val mMoviePopularity: TextView = mView.findViewById<View>(R.id.pop_vote_average) as TextView
        init {
            mView.setOnClickListener(this)
        }
        override fun toString(): String {
            return mMovieTitle.toString()
        }

        override fun onClick(v: View?) {
            val movie = popularMovies[absoluteAdapterPosition]
            val intent = Intent(context, PopularMovieDetailActivity::class.java)
            intent.putExtra(POP_MOVIE_EXTRA, movie)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                v?.context as Activity,
                (mMoviePoster as View?)!!, "popPosterRoll"
            )
            context.startActivity(intent,  options.toBundle())
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = popularMovies[position]

        holder.mMovieTitle.text = movie.title
        holder.mMoviePopularity.text = "Rating: ${movie.vote_average.toString()}"

        val radius = 30

        Glide.with(holder.mView)
            .load(movie.posterImageUrl)
            .centerCrop()
            .transform(RoundedCorners(radius)).into(holder.mMoviePoster)

    }

    override fun getItemCount(): Int {
        return popularMovies.size
    }
}