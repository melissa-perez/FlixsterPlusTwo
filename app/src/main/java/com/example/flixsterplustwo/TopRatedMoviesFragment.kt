package com.example.flixsterplustwo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONArray

private const val TAG = "TopRatedMoviesFragment/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val TOP_RATED_MOVIES_URL =
    "https://api.themoviedb.org/3/movie/top_rated"

class TopRatedMoviesFragment : Fragment(), OnListFragmentInteractionListener {
    private lateinit var progressBar: ContentLoadingProgressBar
    private lateinit var recyclerView: RecyclerView
    private var topRatedMovies: MutableList<TopRatedMovie> = mutableListOf()
    private var page = 1
    private lateinit var adapter: TopRatedMoviesRecyclerAdapter



    override fun onItemClick(item: TopRatedMovie) {
        Toast.makeText(context, "Hello!!!", Toast.LENGTH_LONG).show()
    }
}