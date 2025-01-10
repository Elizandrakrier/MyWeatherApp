package br.com.elizandrakrier.myweatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.elizandrakrier.myweatherapp.databinding.FragmentHomeBinding
import br.com.elizandrakrier.myweatherapp.viewmodel.WeatherViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        weatherViewModel.weatherData.observe(this, Observer { weatherResponse ->
            if (weatherResponse != null) {
                val temperatura = weatherResponse.main?.temp ?: ""
                binding.txtTempo.text = "$temperatura°C"
            }
        })

        weatherViewModel.fetchWeather()
    }
}