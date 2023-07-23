package com.example.bookmyshowapp.data

import com.example.bookmyshowapp.model.Showtime

interface ShowTimeRepository {
    suspend fun getShowDetails() : List<Showtime>
}