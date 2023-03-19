package com.example.flixsterplustwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private const val TAG = "MainActivity/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val TOP_RATED_MOVIES_URL =
    "https://api.themoviedb.org/3/movie/top_rated"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.id.layout.activity_main)
    }
}