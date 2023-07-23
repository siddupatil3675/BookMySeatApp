package com.example.bookmyshowapp.model


data class Showtime(
    val movie: String,
    val theatre: String,
    val address: String,
    val time: String,
    val seatLayout: List<List<String>>
)