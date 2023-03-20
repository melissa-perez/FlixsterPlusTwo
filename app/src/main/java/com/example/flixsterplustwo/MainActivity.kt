package com.example.flixsterplustwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.flixsterplustwo.R.id


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_main
        )
        val topSupportFragmentManager = supportFragmentManager
        val topFragmentTransaction = topSupportFragmentManager.beginTransaction()
        topFragmentTransaction.replace(id.topMovies, TopRatedMoviesFragment(), null).commit()

        val popSupportFragmentManager = supportFragmentManager
        val popFragmentTransaction = popSupportFragmentManager.beginTransaction()
        popFragmentTransaction.replace(id.popularMovies, PopularMoviesFragment(), null).commit()
    }
}