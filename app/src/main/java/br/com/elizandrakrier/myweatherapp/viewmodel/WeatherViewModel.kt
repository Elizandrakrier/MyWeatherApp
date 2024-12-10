package br.com.elizandrakrier.myweatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.elizandrakrier.myweatherapp.models.WeatherResponse
import br.com.elizandrakrier.myweatherapp.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class WeatherViewModel: ViewModel() {
    private val repository = WeatherRepository()
    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> get() = _weatherData

    fun fetchWeather(
        lat: Double,
        lon: Double,
        apiKey: String,
        units: String = "metric",
        lang: String = "pt"
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