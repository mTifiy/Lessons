package com.example.codebuss.thisismyweather.presenters

import com.example.codebuss.thisismyweather.view.MainView

class MainPresenter : BasePresenter<MainView>(){
    //TODO тут будет елемент репозитория
    override fun enable() {

    }

    fun refresh(lat: String, long: String){
        viewState.setLocation(true)
        //TODO тут будет обращение к репозиторию

    }
}