package ru.yandex.practicum.moviessearch.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.yandex.practicum.moviessearch.data.dto.MovieCastResponse
import ru.yandex.practicum.moviessearch.data.dto.MovieDetailsResponse
import ru.yandex.practicum.moviessearch.data.dto.MoviesSearchResponse

interface IMDbApiService {

    @GET("/en/API/SearchMovie/YOUR_API_KEY/{expression}")
    fun searchMovies(@Path("expression") expression: String): Call<MoviesSearchResponse>

    @GET("/en/API/Title/YOUR_API_KEY/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: String): Call<MovieDetailsResponse>

    @GET("/en/API/FullCast/YOUR_API_KEY/{movie_id}")
    fun getFullCast(@Path("movie_id") movieId: String): Call<MovieCastResponse>
}