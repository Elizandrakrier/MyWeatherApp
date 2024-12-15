package br.com.elizandrakrier.myweatherapp.models

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("base") val base: String,
    @SerializedName("base") val visibility: Int,
    @SerializedName("base") val timrCalc: Long,
    @SerializedName("base") val idCity: Int,
    @SerializedName("base") val name: String,
    @SerializedName("base") val cod: Int,
    @SerializedName("base") val coord: Coord,
    @SerializedName("base") val weather: List<Weather>,
    @SerializedName("base") val main: Main,
    @SerializedName("base") val wind: Wind,
    @SerializedName("base") val clouds: Clouds,
    @SerializedName("base") val sys: Sys,
    @SerializedName("base") val timezone: Int
)

data class Coord(
    @SerializedName("base") val lon: Double,
    @SerializedName("base") val lat: Double
)

data class Weather(
    @SerializedName("base") val id: Int,
    @SerializedName("base") val main: String,
    @SerializedName("base") val description: String,
    @SerializedName("base") val icon: String
)

data class Main(
    @SerializedName("base") val temp: Double,
    @SerializedName("base") val feels_like: Double,
    @SerializedName("base") val temp_min: Double,
    @SerializedName("base") val temp_max: Double,
    @SerializedName("base") val pressure: Int,
    @SerializedName("base") val humidity: Int
)

data class Wind(
    @SerializedName("base") val speed: Double,
    @SerializedName("base") val deg: Int
)

data class Clouds(
    @SerializedName("base") val all: Int
)

data class Sys(
    @SerializedName("base") val country: String,
    @SerializedName("base") val sunrise: Long?,
    @SerializedName("base") val sunset: Long?
)