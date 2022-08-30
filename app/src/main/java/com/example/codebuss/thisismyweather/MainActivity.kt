package com.example.codebuss.thisismyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_citi_name.text = "Кропивницкий"
        main_day_data.text = "30 августа"
        main_weather_condition_icon.setImageResource(R.drawable.ic_sun)
        main_temp.text = "25\u00B0"
        main_temp_min.text = "19"
        main_temp_max.text = "25"
        main_image_of_weather.setImageResource(R.mipmap.cloud3x)

    }
}