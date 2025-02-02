package br.com.elizandrakrier.myweatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.elizandrakrier.myweatherapp.databinding.FragmentHomeBinding
import br.com.elizandrakrier.myweatherapp.viewmodel.WeatherViewModel
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        weatherViewModel.weatherData.observe(this) { weatherResponse ->
            if (weatherResponse != null) {
                val temperatura = weatherResponse.main.temp.toInt()
                val sensacaoTermica = weatherResponse.main.feels_like.toInt()
                val maxima = weatherResponse.main.temp_max.toInt()
                val minina = weatherResponse.main.temp_min.toInt()
                val umidade = weatherResponse.main.humidity
                val visibilidade = weatherResponse.visibility.toDouble()
                binding.txtTempo.text = "$temperatura°C"
                binding.txtNumSensacao.text = "$sensacaoTermica°C"
                binding.txtNumMaxmin.text = "$maxima°C / $minina°C"
                binding.txtNumUmidade.text = "$umidade%"
                binding.txtNumVisibilidade.text = "$visibilidade km"
            }

            Glide
                .with(this)
                .load("https://openweathermap.org/img/wn/"+weatherResponse.weather.first().icon+"@2x.png")
                .into(binding.imgTempo)
        }

        weatherViewModel.fetchWeather()
    }
}
