package com.calvert.kotlinretrofitrxjavarecyclerviewtough.network

import com.calvert.kotlinretrofitrxjavarecyclerviewtough.model.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*

interface ApiInterface {

    //https://reqres.in/api/users
    @GET("users")
    fun getUsers(): Observable<User>

    companion object{
        private var BASE_URL = "https://reqres.in/api/"

        fun getRetrofit(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                //needed for RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}