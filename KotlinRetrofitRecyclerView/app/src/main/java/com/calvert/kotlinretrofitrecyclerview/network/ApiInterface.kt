package com.calvert.kotlinretrofitrecyclerview.network

import com.calvert.kotlinretrofitrecyclerview.model.UserModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    //https://reqres.in/api/users

    @GET("users")
//    fun getUsers(): Call<UserModel>
    fun getUsers(): Observable<UserModel>

    companion object{
        var BASE_URL = "https://reqres.in/api/"

        fun getRetrofit(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

            return retrofit.create(ApiInterface::class.java)
        }
    }
}