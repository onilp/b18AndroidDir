package com.calvert.retrofitrxjavadagger2.di;

import com.calvert.retrofitrxjavadagger2.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

@Singleton
@Component(modules = {RetrofitModule.class})
public interface MyComponent {
    void injectRetrofit(MainActivity mainActivity);
}
