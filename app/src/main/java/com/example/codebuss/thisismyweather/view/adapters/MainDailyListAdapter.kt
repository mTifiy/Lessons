package com.example.codebuss.thisismyweather.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.codebuss.thisismyweather.R
import com.example.codebuss.thisismyweather.bussiness.model.DailyWeatherModel
import com.example.codebuss.thisismyweather.databinding.ItemMainDailyBinding
import com.google.android.material.textview.MaterialTextView
import kotlin.math.min

/*
 * На этом месте будет стоять обработчик нажати1
 */
class MainDailyListAdapter : BaseAdapter<DailyWeatherModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_daily,parent,false)
        return DailyViewHolder(view)
    }

//    override fun getItemCount()  = 8

    inner class DailyViewHolder(view : View) : BaseViewHolder(view){
        var date: MaterialTextView = view.findViewById(R.id.item_daily_date_tv)
        var popRate: MaterialTextView = view.findViewById(R.id.item_daily_pop_tv)
        var maxTemp: MaterialTextView = view.findViewById(R.id.item_daily_max_temp)
        var minTemp: MaterialTextView = view.findViewById(R.id.item_daily_min_temp)
        var icon: ImageView = view.findViewById(R.id.item_daily_weather_condition_icon)

        override fun bindView(position: Int) {
            date.text = "30 October"
            popRate.text = "35 %"
            maxTemp.text = "35"
            minTemp.text = "25"
            icon.setImageResource(R.drawable.ic_muun)
        }

    }
}
