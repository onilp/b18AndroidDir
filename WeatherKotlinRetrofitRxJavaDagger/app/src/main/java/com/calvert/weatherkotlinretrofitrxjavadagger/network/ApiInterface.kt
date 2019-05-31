package com.calvert.weatherkotlinretrofitrxjavadagger.network

import com.calvert.weatherkotlinretrofitrxjavadagger.model.LondonWeather
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    // https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22

    @GET("weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    fun getLondonWeather(): Observable<LondonWeather>

//    companion object{
//        var BASE_URL = "https://samples.openweathermap.org/data/2.5/"
//
//        fun getRetrofit(): ApiInterface{
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//
//            return retrofit.create(ApiInterface::class.java)
//        }
//    }
}