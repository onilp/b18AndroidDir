package com.calvert.kotlinretrofitrxjavarecyclerview3.network

import com.calvert.kotlinretrofitrxjavarecyclerview3.model.Comment
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    //        https://jsonplaceholder.typicode.com/comments

    // 1) End point
    @GET("comments")
    fun getPost(): Call<List<Comment>>

    companion object{
        var BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun getRetrofit(): ApiInterface{

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

            return retrofit.create(ApiInterface::class.java)
        }
    }
}