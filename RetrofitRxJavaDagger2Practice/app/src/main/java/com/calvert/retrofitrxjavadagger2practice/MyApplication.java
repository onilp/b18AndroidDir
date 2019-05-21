package com.calvert.retrofitrxjavadagger2practice;

import android.app.Application;

import com.calvert.retrofitrxjavadagger2practice.di.DaggerMyComponent;
import com.calvert.retrofitrxjavadagger2practice.di.MyComponent;
import com.calvert.retrofitrxjavadagger2practice.di.RetrofitModule;

public class MyApplication extends Application {
    private MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyComponent.builder()
                .retrofitModule(new RetrofitModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public MyComponent getComponent(){
        return component;
    }
}
