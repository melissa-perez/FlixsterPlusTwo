package com.example.flixsterplustwo

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

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
    val poster: String?,
    @SerialName("backdrop_path")
    val backdrop: String?,
    @SerialName("popularity")
    val popularity: Float?,
    @SerialName("vote_count")
    val vote_count: Int?,
    @SerialName("vote_average")
    val vote_average: Float?,
    @SerialName("release_date")
    val release_date: String?
) : java.io.Serializable {
    val posterImageUrl =
        "https://image.tmdb.org/t/p/w342/${poster}"
    val backdropImageUrl =
        "https://image.tmdb.org/t/p/w342/${backdrop}"
}