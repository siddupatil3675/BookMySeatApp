package com.example.bookmyshowapp.di

import android.util.Log
import com.example.bookmyshowapp.data.ShowTimeRepository
import com.example.bookmyshowapp.data.remote.ShowApi
import com.example.bookmyshowapp.data.repository.ShowTimeRepositoryImpl
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShowTimeModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                LoggingInterceptor.Builder()
                    .setLevel(Level.BASIC)
                    .log(Log.VERBOSE)
                    .build()
            ).build()
    }

    @Provides
    @Singleton
    fun providesShowApi(okHttpClient: OkHttpClient): ShowApi {
        val baseUrl = "https://run.mocky.io/v3/2c7a2d24-6e7b-4fbe-9d46-2a86883a81cd" + "/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShowApi::class.java)
    }

    @Provides
    @Singleton
    fun providesShowRepository(showApi: ShowApi): ShowTimeRepository {
        return ShowTimeRepositoryImpl(showApi)
    }
}