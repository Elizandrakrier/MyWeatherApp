package br.com.elizandrakrier.myweatherapp.api

import br.com.elizandrakrier.myweatherapp.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("weather")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "pt"
    ) : Call<WeatherResponse>
}

