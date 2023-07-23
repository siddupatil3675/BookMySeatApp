package com.example.bookmyshowapp.data.repository

import com.example.bookmyshowapp.data.ShowTimeRepository
import com.example.bookmyshowapp.data.remote.ShowApi
import com.example.bookmyshowapp.model.Showtime

class ShowTimeRepositoryImpl(
    private val showApi: ShowApi
) : ShowTimeRepository {
    override suspend fun getShowDetails(): List<Showtime>{
        return showApi.getShowTimeDetails()
    }
}