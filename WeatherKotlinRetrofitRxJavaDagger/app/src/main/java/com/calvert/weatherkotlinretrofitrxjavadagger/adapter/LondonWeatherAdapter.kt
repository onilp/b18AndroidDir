package com.calvert.weatherkotlinretrofitrxjavadagger.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.calvert.weatherkotlinretrofitrxjavadagger.R
import com.calvert.weatherkotlinretrofitrxjavadagger.model.Weather
import kotlinx.android.synthetic.main.list_london_weather.view.*

class WeatherAdapter(val context: Context, val weatherList: List<Weather>) :    RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): WeatherViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_london_weather, parent, false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(viewHolder: WeatherViewHolder, position: Int) {
        viewHolder.bindValues(weatherList.get(position))
    }

    class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindValues(weather: Weather){
            itemView.id_tv.text = weather.id.toString()
            itemView.main_tv.text = weather.main
            itemView.description_tv.text = weather.description
            itemView.icon_tv.text = weather.icon
        }
    }
}