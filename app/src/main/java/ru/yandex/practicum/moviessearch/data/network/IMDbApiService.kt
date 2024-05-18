package ru.yandex.practicum.moviessearch.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.yandex.practicum.moviessearch.data.dto.MovieCastResponse
import ru.yandex.practicum.moviessearch.data.dto.MovieDetailsResponse
import ru.yandex.practicum.moviessearch.data.dto.MoviesSearchResponse
import ru.yandex.practicum.moviessearch.data.dto.NamesSearchResponse

interface IMDbApiService {

    companion object {
        private const val IMDB_KEY = "k_zcuw1ytf"
    }

    @GET("/en/API/SearchName/$IMDB_KEY/{expression}")
    fun searchNames(@Path("expression") expression: String): Call<NamesSearchResponse>

    @GET("/en/API/SearchMovie/$IMDB_KEY/{expression}")
    fun searchMovies(@Path("expression") expression: String): Call<MoviesSearchResponse>

    @GET("/en/API/Title/$IMDB_KEY/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: String): Call<MovieDetailsResponse>

    @GET("/en/API/FullCast/$IMDB_KEY/{movie_id}")
    fun getFullCast(@Path("movie_id") movieId: String): Call<MovieCastResponse>
}