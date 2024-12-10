package br.com.elizandrakrier.myweatherapp.models

data class WeatherResponse(
    val base: String?,
    val visibility: Int?,
    val dt: Long?,
    val id: Int?,
    val name: String?,
    val cod: Int?,
    val coord: Coord?,
    val weather: List<Weather>?,
    val main: Main?,
    val wind: Wind?,
    val clouds: Clouds?,
    val sys: Sys?,
    val timezone: Int?
)

data class Coord(
    val lon: Double?,
    val lat: Double?
)

data class Weather(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?
)

data class Main(
    val temp: Double?,
    val feels_like: Double?,
    val temp_min: Double?,
    val temp_max: Double?,
    val pressure: Int?,
    val humidity: Int?
)

data class Wind(
    val speed: Double?,
    val deg: Int?
)

data class Clouds(
    val all: Int?
)

data class Sys(
    val country: String?,
    val sunrise: Long?,
    val sunset: Long?
)