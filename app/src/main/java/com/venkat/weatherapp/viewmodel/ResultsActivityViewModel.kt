package com.venkat.weatherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.venkat.weatherapp.model.WeatherResponse
import com.venkat.weatherapp.repository.ResultsActivityRepo

class ResultsActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val repository =
        ResultsActivityRepo(application)
    val showProgress : LiveData<Boolean>
    val response : LiveData<WeatherResponse>

    init {
        showProgress = repository.showProgress
        response = repository.response
    }

    fun getWeather(woeId : Int){
        repository.getWeather(woeId)
    }
}