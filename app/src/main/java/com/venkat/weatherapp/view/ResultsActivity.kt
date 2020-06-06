package com.venkat.weatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.venkat.weatherapp.viewmodel.ResultsActivityViewModel
import com.venkat.weatherapp.R
import kotlinx.android.synthetic.main.activity_results.*

class ResultsActivity : AppCompatActivity() {

    private lateinit var viewModel: ResultsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        viewModel = ViewModelProvider(this).get(ResultsActivityViewModel::class.java)

        if (intent.hasExtra("name")) {
            tv_location.text = intent.getStringExtra("name")
        }

        if (intent.hasExtra("Location")) {
            val location = intent.getIntExtra("Location", 0)
            if (location > 0)
                viewModel.getWeather(location)
        }

        viewModel.showProgress.observe(this, Observer {
            if (it)
                details_progress.visibility = VISIBLE
            else
                details_progress.visibility = GONE
        })

        viewModel.response.observe(this, Observer {
            if (it != null) {
                tv_temp.text = it.consolidated_weather[0].the_temp.toString() + " C"
                minTemp.text = "Min " + it.consolidated_weather[0].min_temp.toString() + "C"
                maxTemp.text = "Max " + it.consolidated_weather[0].max_temp.toString() + "C"
                weather_state.text = it.consolidated_weather[0].weather_state_name
                wind_speed.text = "Wind Speed "+it.consolidated_weather[0].wind_speed.toString()+" mph"
                air_pressure.text = "Pressure "+it.consolidated_weather[0].air_pressure.toString()+" mb"
                humidity.text = "Humidity "+it.consolidated_weather[0].humidity.toString()+"%"
                visibility.text = "Visibility "+it.consolidated_weather[0].visibility.toString()+" miles"
                predictability.text = "Confidence "+it.consolidated_weather[0].predictability.toString()+"%"

            }
        })

    }
}
