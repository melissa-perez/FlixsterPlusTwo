package com.example.flixsterplustwo

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class BaseResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<TopRatedMovie>?,
)

@Keep
@Serializable
data class TopRatedMovie(
    @SerialName("title")
    val title: String,
    @SerialName("overview")
    val overview: String?,
    @SerialName("poster_path")
    val poster: String?
) : java.io.Serializable {
    val mediaImageUrl =
        "https://image.tmdb.org/t/p/w342/${poster}"
}