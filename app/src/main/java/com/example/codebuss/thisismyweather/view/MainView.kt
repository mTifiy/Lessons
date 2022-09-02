package com.example.codebuss.thisismyweather.view

import com.example.codebuss.thisismyweather.bussiness.model.DailyWeatherModel
import com.example.codebuss.thisismyweather.bussiness.model.HaurlyWeathermodel
import com.example.codebuss.thisismyweather.bussiness.model.WeatherData
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface MainView : MvpView {


    @AddToEndSingle
    fun displayLocation(data: String)

    @AddToEndSingle
    fun displayCurrentDatta(data: WeatherData)

    @AddToEndSingle
    fun displayHourlyData(data: List<HaurlyWeathermodel>)

    @AddToEndSingle
    fun displayDailyData(data: List<DailyWeatherModel>)

    @AddToEndSingle
    fun displayError(error: Throwable)

    @AddToEndSingle
    fun setLoading(flag: Boolean)
}