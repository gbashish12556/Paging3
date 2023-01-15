package com.example.paging3

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("movie/popular?api_key=348y34594y9&language=en-US")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MovieResponse
}