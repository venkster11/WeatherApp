package com.venkat.weatherapp.model

import com.venkat.weatherapp.model.ConsolidatedWeather

data class WeatherResponse(
    val consolidated_weather: List<ConsolidatedWeather>,
    val time: String,
    val title: String,
    val woeid: Int
)