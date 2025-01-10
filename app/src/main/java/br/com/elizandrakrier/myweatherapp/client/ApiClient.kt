package br.com.elizandrakrier.myweatherapp.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
        fun getRetrofit() : Retrofit {
            val baseUrl = "https://api.openweathermap.org/data/2.5/"
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
