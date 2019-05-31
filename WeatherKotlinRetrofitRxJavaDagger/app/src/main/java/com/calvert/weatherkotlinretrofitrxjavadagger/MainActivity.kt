package com.calvert.weatherkotlinretrofitrxjavadagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Adapter
import com.calvert.weatherkotlinretrofitrxjavadagger.adapter.WeatherAdapter
import com.calvert.weatherkotlinretrofitrxjavadagger.di.DaggerMyComponent
import com.calvert.weatherkotlinretrofitrxjavadagger.di.MyComponent
import com.calvert.weatherkotlinretrofitrxjavadagger.di.RetrofitModule
import com.calvert.weatherkotlinretrofitrxjavadagger.model.LondonWeather
import com.calvert.weatherkotlinretrofitrxjavadagger.network.ApiInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiInterface: ApiInterface
    lateinit var myComponent: MyComponent

    lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        myComponent = DaggerMyComponent.builder().retrofitModule(RetrofitModule).build()
        myComponent.injectRetrofit(this@MainActivity)
        apiInterface.getLondonWeather()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ it ->
                Log.d("Response", it.weather.toString())
                weatherAdapter = WeatherAdapter(this@MainActivity, it.weather)
                weatherRecyclerView.adapter = weatherAdapter
                weatherAdapter.notifyDataSetChanged()
            }, { it ->
                Log.e("Error", it.message)
            })

//        getWeather()
    }

//    private fun getWeather() {
//        val apiInterface = ApiInterface.getRetrofit().getLondonWeather()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({it ->
//                Log.d("Response", it.weather.toString())
//                weatherAdapter = WeatherAdapter(this@MainActivity, it.weather)
//                weatherRecyclerView.adapter = weatherAdapter
//                weatherAdapter.notifyDataSetChanged()
//            }, {it ->
//                Log.e("Error",it.message)
//            })
//    }

    private fun init() {
        weatherRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
