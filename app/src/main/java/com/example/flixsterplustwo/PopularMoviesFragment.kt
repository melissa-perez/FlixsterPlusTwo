package com.example.flixsterplustwo

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

private const val TAG = "PopularMoviesFragment/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val POP_RATED_MOVIES_URL =
    "https://api.themoviedb.org/3/movie/popular"

class PopularMoviesFragment : Fragment() {
    private lateinit var progressBar: ContentLoadingProgressBar
    private lateinit var popularRecyclerView: RecyclerView
    private var popularMovies: MutableList<PopularMovie> = mutableListOf()
    private var page = 1
    private lateinit var adapter: PopularMoviesRecyclerAdapter

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
            R.layout.fragment_popular_movies_list, container,
            false
        )
        progressBar = view.findViewById<View>(R.id.popProgress) as ContentLoadingProgressBar
        popularRecyclerView = view.findViewById<View>(R.id.popList) as RecyclerView

        val context = view.context
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        popularRecyclerView.layoutManager = linearLayoutManager
        adapter =
            PopularMoviesRecyclerAdapter(context, popularMovies)
        popularRecyclerView.adapter = adapter

        Log.d(TAG, "Called updateAdapter")
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

        client["$POP_RATED_MOVIES_URL?", params, object :
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

                val parsedJson = createJson().decodeFromString(
                    Response.serializer(),
                    json?.jsonObject.toString()
                )

                parsedJson.results?.let { otherlist ->
                    popularMovies.addAll(otherlist)

                    adapter.notifyDataSetChanged()
                }
            }
        }]

    }
}