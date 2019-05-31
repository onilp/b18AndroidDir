package com.calvert.weatherkotlinretrofitrxjavadagger.di

import com.calvert.weatherkotlinretrofitrxjavadagger.network.ApiInterface
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object RetrofitModule {

    var BASE_URL = "https://samples.openweathermap.org/data/2.5/"

    @Provides
    internal fun provideRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    internal fun provideApiInterface(retrofit: Retrofit): ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }
}