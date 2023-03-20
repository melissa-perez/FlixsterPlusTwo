package com.example.flixsterplustwo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "TopRatedMovieRecyclerAdapter/"

class TopRatedMoviesRecyclerAdapter(
    private val context: Context,
    private val topRatedMovies: List<TopRatedMovie>
    ) : RecyclerView.Adapter<TopRatedMoviesRecyclerAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_top_rated_movie, parent, false)
        return MovieViewHolder(view)
    }

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView),
        View.OnClickListener {
        val mMoviePoster: ImageView = mView.findViewById<View>(R.id.movie_image) as ImageView
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
        val mMovieOverview: TextView = mView.findViewById<View>(R.id.movie_overview) as TextView
        init {
            mView.setOnClickListener(this)
        }
        override fun toString(): String {
            return mMovieTitle.toString() + " '" + mMovieOverview.text + "'"
        }

        override fun onClick(v: View?) {
            val movie = topRatedMovies[absoluteAdapterPosition]
            val intent = Intent(context, TopRatedMovieDetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = topRatedMovies[position]

        holder.mMovieTitle.text = movie.title
        holder.mMovieOverview.text = movie.overview

        val radius = 30

        Glide.with(holder.mView)
            .load(movie.mediaImageUrl)
            .centerCrop()
            .transform(RoundedCorners(radius)).into(holder.mMoviePoster)

    }

    override fun getItemCount(): Int {
        return topRatedMovies.size
    }
}