package com.example.bookmyshowapp.data.remote

import com.example.bookmyshowapp.model.Showtime
import retrofit2.http.GET


interface ShowApi {
    @GET("users")
    suspend fun getShowTimeDetails() : List<Showtime>
}