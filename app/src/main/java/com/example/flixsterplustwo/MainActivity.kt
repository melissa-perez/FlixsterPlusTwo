package com.example.flixsterplustwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flixsterplustwo.R.id

private const val TAG = "MainActivity/"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val TOP_RATED_MOVIES_URL =
    "https://api.themoviedb.org/3/movie/top_rated"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_main
        )
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.content, TopRatedMoviesFragment(), null).commit()
    }
}