package com.travelapp.retrofitdagger.di;

import com.travelapp.retrofitdagger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {APIModule.class})
@Singleton
public interface MyComponent {

    void injectRetrofit(MainActivity activity);
}
