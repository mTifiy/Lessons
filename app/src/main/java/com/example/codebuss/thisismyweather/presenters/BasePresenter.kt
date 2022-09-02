package com.example.codebuss.thisismyweather.presenters

import com.example.codebuss.thisismyweather.view.MainView
import moxy.MvpPresenter

abstract class BasePresenter<T: MainView> : MvpPresenter<T>() {
    abstract fun enable()
}