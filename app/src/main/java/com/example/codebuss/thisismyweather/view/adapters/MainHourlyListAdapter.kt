package com.example.codebuss.thisismyweather.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codebuss.thisismyweather.R

const val TAG ="RV_TEST"

class MainHourlyListAdapter : RecyclerView.Adapter<MainHourlyListAdapter.HourlyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        Log.d(TAG, "-----onCreateViewHolder: ")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_hauer,parent,false)
        return HourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: ")

    }

    override fun getItemCount() = 30

    inner class HourlyViewHolder(view: View) : RecyclerView.ViewHolder(view){

        init {
            Log.d(TAG, "HourlyViewHolder: ")
        }

    }
}
