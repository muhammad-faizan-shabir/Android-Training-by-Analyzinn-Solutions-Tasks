package com.example.weatherforecastapp


import androidx.activity.enableEdgeToEdge

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var cityTextView: TextView
    lateinit var currentTempTextView: TextView
    lateinit var feelsLikeTextView: TextView
    lateinit var timeTextView: TextView
    lateinit var forecastTextview: TextView
    lateinit var forecastDetailsTextView: TextView
    lateinit var weatherTextView: TextView
    lateinit var inputCity:EditText
    lateinit var forecastButton: Button
    lateinit var img: ImageView
    var cityNameList= listOf("Lahore","Karachi")
    var tempList=listOf("31°C","40°C")
    var feelsLike=listOf("Feels Like: 39°C","Feels Like: 45°C")
    var timeList=listOf("Time: 3:22 AM","Time: 4:22 AM")
    var forecastList=listOf("30, 29, 29, 29, 29, 31, 32, 34, 35, 35, 35 degrees","30, 29, 29, 29, 29, 31, 32, 34, 35, 35, 35 degrees")
    var weatherDescriptionList=listOf("Humid and Sunny Today","Dry and Cold Today")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        setListeners()
    }

    private fun initUI()
    {
        // Initialize views
        cityTextView = findViewById(R.id.cityTextView)
        currentTempTextView = findViewById(R.id.currentTempTextView)
        feelsLikeTextView = findViewById(R.id.feelsLikeTextView)
        timeTextView = findViewById(R.id.timeTextView)
        forecastTextview=findViewById(R.id.forecastTextView)
        forecastDetailsTextView = findViewById(R.id.forecastDetailsTextView)
        weatherTextView = findViewById(R.id.weatherTextView)
        inputCity=findViewById(R.id.editText)
        forecastButton=findViewById(R.id.Button)
        img=findViewById(R.id.imageView)
    }

    private fun setListeners()
    {
        forecastButton.setOnClickListener {
            var cityName= inputCity.text.toString()
            if(cityName in cityNameList )
            {
                var index=cityNameList.indexOf(cityName)
                cityTextView.text=cityNameList[index]
                currentTempTextView.text=tempList[index]
                feelsLikeTextView.text=feelsLike[index]
                timeTextView.text=timeList[index]
                forecastTextview.text="Forecast for the Next Few Hours:"
                forecastDetailsTextView.text=forecastList[index]
                weatherTextView.text=weatherDescriptionList[index]
                var city=cityNameList[index]
                if(city =="Lahore")
                {
                    img.setImageResource(R.drawable.lahore)

                }
                else
                {
                    img.setImageResource(R.drawable.karachi)

                }



            }
            else
            {
                cityTextView.text="Invalid City"
                currentTempTextView.text=""
                feelsLikeTextView.text=""
                timeTextView.text=""
                forecastTextview.text=""
                forecastDetailsTextView.text=""
                weatherTextView.text=""
                inputCity.setText("")

                img.setImageDrawable(null)

            }
        }
    }

    
}