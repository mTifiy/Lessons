package com.example.codebuss.thisismyweather.presenters

import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresent <T: MvpView> : MvpPresenter<T>() {
    abstract fun enable()
}