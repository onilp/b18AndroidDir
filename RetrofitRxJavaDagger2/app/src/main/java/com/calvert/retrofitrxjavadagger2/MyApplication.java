package com.calvert.retrofitrxjavadagger2;

import android.app.Application;

import com.calvert.retrofitrxjavadagger2.di.DaggerMyComponent;
import com.calvert.retrofitrxjavadagger2.di.MyComponent;
import com.calvert.retrofitrxjavadagger2.di.RetrofitModule;

public class MyApplication extends Application {

    private MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyComponent.builder()
                .retrofitModule(new RetrofitModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public MyComponent getComponent() {
        return component;
    }
}
