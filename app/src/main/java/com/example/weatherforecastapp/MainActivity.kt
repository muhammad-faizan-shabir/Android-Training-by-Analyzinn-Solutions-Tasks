package com.example.weatherforecastapp


import androidx.activity.enableEdgeToEdge

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var cityTextView: TextView
    lateinit var currentTempTextView: TextView
    lateinit var feelsLikeTextView: TextView
    lateinit var timeTextView: TextView
    lateinit var forecastDetailsTextView: TextView
    lateinit var weatherTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        cityTextView = findViewById(R.id.cityTextView)
        currentTempTextView = findViewById(R.id.currentTempTextView)
        feelsLikeTextView = findViewById(R.id.feelsLikeTextView)
        timeTextView = findViewById(R.id.timeTextView)
        forecastDetailsTextView = findViewById(R.id.forecastDetailsTextView)
        weatherTextView = findViewById(R.id.weatherTextView)

        // Display weather information
        displayWeather()
    }

    private fun displayWeather() {
        // Example weather data
        val cityName = "Lahore"
        val currentTemp = "31°C"
        val feelsLikeTemp = "Feels Like: 39°C"
        val currentTime = "Time: 3:22 AM"
        val forecast = "30, 29, 29, 29, 29, 31, 32, 34, 35, 35, 35, 34 degrees"
        val weatherDescription = "Humid and Sunny Today"

        // Update UI with weather information
        cityTextView.text = cityName
        currentTempTextView.text = "Current Temperature: $currentTemp"
        feelsLikeTextView.text = feelsLikeTemp
        timeTextView.text = currentTime
        forecastDetailsTextView.text = forecast
        weatherTextView.text = weatherDescription
    }
}