package com.calvert.weatherkotlinretrofitrxjavadagger.di

import com.calvert.weatherkotlinretrofitrxjavadagger.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(RetrofitModule::class))
interface MyComponent {
    fun injectRetrofit(mainActivity: MainActivity)
}