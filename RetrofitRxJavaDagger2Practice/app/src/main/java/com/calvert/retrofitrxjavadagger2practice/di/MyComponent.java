package com.calvert.retrofitrxjavadagger2practice.di;

import com.calvert.retrofitrxjavadagger2practice.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface MyComponent {
    void injectRetrofit(MainActivity mainActivity);
}
