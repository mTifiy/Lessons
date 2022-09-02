package com.example.codebuss.thisismyweather

import android.app.Application
import android.content.Intent

const val APP_SETTINGS = "App settings"
const val IS_STARTED_UP = "Is started up"

class App : Application() {

    // TODO переменная базы данных

    override fun onCreate() {

        // TODO Инициализация базы данных
        super.onCreate()
        val preferences = getSharedPreferences(APP_SETTINGS, MODE_PRIVATE)
        val flag = preferences.contains(IS_STARTED_UP)

        if (flag){

            // preferences.edit().putBoolean(IS_STARTED_UP, true).apply() А можно так?

            val editor = preferences.edit()
            editor.putBoolean(IS_STARTED_UP, true)
            editor.apply()

            val intent = Intent(this, InitialActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

}