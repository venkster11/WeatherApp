package com.venkat.weatherapp.model

data class ConsolidatedWeather(
    val id: Long,
    val the_temp: Double,
    val weather_state_name: String,
    val wind_speed: Int,
    val min_temp: Int,
    val max_temp: Int,
    val air_pressure: Int,
    val humidity: Int,
    val visibility: Int,
    val predictability: Int
)