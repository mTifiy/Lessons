package com.example.codebuss.thisismyweather.presenters

import com.example.codebuss.thisismyweather.view.MainView

class MainPresenter : BasePresent<MainView>() {

    // тут переменная репозитория
    override fun enable() {

    }

    fun refresh(lat: String, long: String){
        viewState.setLoading(true)
        // TODO тут будет обращение к репозиторию
    }


}