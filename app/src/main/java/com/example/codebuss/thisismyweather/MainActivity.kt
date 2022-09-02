package com.example.codebuss.thisismyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codebuss.thisismyweather.databinding.ActivityMainBinding
import com.example.codebuss.thisismyweather.view.adapters.MainDailyListAdapter
import com.example.codebuss.thisismyweather.view.adapters.MainHourlyListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }


        bindingMain.mainHourlyList.apply {
            adapter = MainHourlyListAdapter() // Отвечает за расположение обьекта
            // динамическое изминение размеров обьекта откулючино
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            // Установить фиксированный размер
            setHasFixedSize(true)
        }

        bindingMain.mainDailyList.adapter = MainDailyListAdapter()
        bindingMain.mainDailyList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bindingMain.mainDailyList.setHasFixedSize(true)

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