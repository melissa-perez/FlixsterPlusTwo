package com.example.flixsterplustwo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import kotlinx.serialization.json.Json
import okhttp3.Headers
import org.json.JSONArray

private const val TAG = "TopRatedMoviesFragment/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val TOP_RATED_MOVIES_URL =
    "https://api.themoviedb.org/3/movie/top_rated"

class TopRatedMoviesFragment : Fragment(), OnListFragmentInteractionListener {
    private lateinit var progressBar: ContentLoadingProgressBar
    private lateinit var topRatedRecyclerView: RecyclerView
    private var topRatedMovies: MutableList<TopRatedMovie> = mutableListOf()
    private var page = 1
    private lateinit var adapter: TopRatedMoviesRecyclerAdapter

    override fun onItemClick(item: TopRatedMovie) {

        val intent = Intent(context, TopRatedMovieDetailActivity::class.java)
        intent.putExtra(MOVIE_EXTRA, item)
        context?.startActivity(intent)
    }

    fun createJson() = Json {
        isLenient = true
        ignoreUnknownKeys = true
        useAlternativeNames = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_top_rated_movies_list, container,
            false
        )
        progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        topRatedRecyclerView = view.findViewById<View>(R.id.topRatedList) as RecyclerView

        val context = view.context
        val linearLayoutManager = LinearLayoutManager(context)
        topRatedRecyclerView.layoutManager = linearLayoutManager
        adapter = TopRatedMoviesRecyclerAdapter(topRatedMovies, this@TopRatedMoviesFragment)
        topRatedRecyclerView.adapter = adapter

        Log.d(TAG, "Called updateAdapter ")
        updateAdapter(progressBar)

        return view
    }

    private fun updateAdapter(progressBar: ContentLoadingProgressBar) {
        progressBar.show()
        val client = AsyncHttpClient()
        val params = RequestParams()
        params["language"] = "en-US"
        params["region"] = "US"
        params["api_key"] = SEARCH_API_KEY
        params["page"] = page.toString()

        client["$TOP_RATED_MOVIES_URL?", params, object :
            JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                progressBar.hide()
                throwable?.message?.let {
                    if (response != null) {
                        Log.e(TAG, response)
                    }
                }
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                progressBar.hide()
                Log.d(TAG, "response successful")
                val movieJsonArray: JSONArray? = json?.jsonObject?.getJSONArray("results")

                val parsedJson = createJson().decodeFromString(
                    BaseResponse.serializer(),
                    json?.jsonObject.toString()
                )

                parsedJson.results?.let { list ->
                    topRatedMovies.addAll(list)

                    adapter.notifyDataSetChanged()
                }
            }
        }]

    }
}