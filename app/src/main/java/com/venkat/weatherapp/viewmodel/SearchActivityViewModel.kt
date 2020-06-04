package com.venkat.weatherapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.venkat.weatherapp.model.Location
import com.venkat.weatherapp.repository.SearchActivityRepo

class SearchActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository  =
        SearchActivityRepo(application)
    val showProgress : LiveData<Boolean>
    val locationList : LiveData<List<Location>>

    init {
        this.showProgress = repository.showProgress
        this.locationList = repository.locationList
    }

    fun searchLocation(searchString: String){
        repository.searchLocation(searchString)
    }
}