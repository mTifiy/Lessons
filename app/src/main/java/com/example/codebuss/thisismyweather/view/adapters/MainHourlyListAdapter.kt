package com.example.codebuss.thisismyweather.view.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.codebuss.thisismyweather.R
import com.example.codebuss.thisismyweather.bussiness.model.HaurlyWeathermodel
import com.example.codebuss.thisismyweather.databinding.ItemMainHauerBinding
import com.google.android.material.textview.MaterialTextView


class MainHourlyListAdapter : BaseAdapter<HaurlyWeathermodel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_hauer, parent, false)
        return HourlyViewHolder(view)
    }


    inner class HourlyViewHolder(view: View) : BaseViewHolder(view) {

        var time: MaterialTextView = view.findViewById(R.id.item_hourly_time_tv)

        var temperature: MaterialTextView = view.findViewById(R.id.item_hourly_temp_tv)

        var popRate: MaterialTextView = view.findViewById(R.id.item_hourly_pop_tv)

        var icon: ImageView = view.findViewById(R.id.item_hourly_weather_condition_icon)

        override fun bindView(position: Int) {
            time.text = "16:00"
            temperature.text = "25"
            popRate.text = "50%"
            icon.setImageResource(R.drawable.ic_muun)
        }
    }
}
