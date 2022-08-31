package com.example.codebuss.thisismyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codebuss.thisismyweather.view.adapters.MainDailyListAdapter
import com.example.codebuss.thisismyweather.view.adapters.MainHourlyListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        main_hourly_list.apply {
            adapter = MainHourlyListAdapter()
            // Отвечает за расположение обьекта
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            // динамическое изминение размеров обьекта откулючино
            setHasFixedSize(true)
        }
        ///gyf


        main_daily_list.adapter = MainDailyListAdapter()
        main_daily_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        main_daily_list.setHasFixedSize(true)

    }

    private fun initViews() {
        main_citi_name.text = "Кропивницкий"
        main_day_data.text = "30 августа"
        main_weather_condition_icon.setImageResource(R.drawable.ic_sun)
        main_temp.text = "25\u00B0"
        main_temp_min.text = "19"
        main_temp_max.text = "25"
        main_image_of_weather.setImageResource(R.mipmap.cloud3x)
        main_pressure_text.text
        main_humidity_text.text
        main_wind_text.text
        main_time_sun_up.text
        main_time_sun_dn.text
    }
}