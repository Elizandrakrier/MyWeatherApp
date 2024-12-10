package br.com.elizandrakrier.myweatherapp.repository

import retrofit2.Call
import br.com.elizandrakrier.myweatherapp.api.Api
import br.com.elizandrakrier.myweatherapp.client.WeatherApiClient
import br.com.elizandrakrier.myweatherapp.models.WeatherResponse

class WeatherRepository {
    private val api = WeatherApiClient.getRetrofit().create(Api::class.java)
    fun getWeatherByLocation(
        lat: Double,
        lon: Double,
        apiKey: String,
        units: String = "metric",
        lang: String = "pt"
    ): Call<WeatherResponse> {
        return api.getWeather(lat, lon, apiKey, units, lang)
    }
}