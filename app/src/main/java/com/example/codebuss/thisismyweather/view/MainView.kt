package com.example.codebuss.thisismyweather.view

import com.example.codebuss.thisismyweather.bussiness.model.DailyWeatherModel
import com.example.codebuss.thisismyweather.bussiness.model.HourlyWeatherModel
import com.example.codebuss.thisismyweather.bussiness.model.WeatherData
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

/**
 * Данный интерфейс служит для сообщения
 */
interface MainView : MvpView {

    @AddToEndSingle
    fun displayLocation(data: String)

    @AddToEndSingle
    fun displayCurrentDatta (data: WeatherData)

    @AddToEndSingle
    fun displayHourlyData(data: List<HourlyWeatherModel>)

    @AddToEndSingle
    fun displayDailyData(data: List<DailyWeatherModel>)

    @AddToEndSingle
    fun displayError(error: Throwable)

    @AddToEndSingle
    fun setLocation(flag: Boolean)
}