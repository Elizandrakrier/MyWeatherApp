package br.com.elizandrakrier.myweatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.elizandrakrier.myweatherapp.keys.WEATHER_API_KEY
import br.com.elizandrakrier.myweatherapp.models.WeatherResponse
import br.com.elizandrakrier.myweatherapp.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class WeatherViewModel: ViewModel() {
    private val repository = WeatherRepository()
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    private val lat = 2.0
    private val lon = 3.0
    private val apiKey = WEATHER_API_KEY
    private val units = "metric"
    private val lang = "pt"

    fun fetchWeather(
    ) {
        repository.getWeatherByLocation(lat, lon, apiKey, units, lang).enqueue(object :
        Callback<WeatherResponse> {
            override fun onResponse( call: Call<WeatherResponse>,
                                     response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    _weatherData.postValue(response.body())
                }
            }
            override fun onFailure( call: Call<WeatherResponse>, t: Throwable){
                // Tratar erros de rede
                t.printStackTrace()
            }
        })
    }
}