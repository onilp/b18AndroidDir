package com.travelapp.retrofitdagger2.di;

import com.travelapp.retrofitdagger2.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {APIModule.class})
@Singleton
public interface MyComponent {
    void injectRetrofit(MainActivity activity);
}
