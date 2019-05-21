package com.travelapp.retrofitdagger2;

import android.app.Application;

import com.travelapp.retrofitdagger2.di.APIModule;
import com.travelapp.retrofitdagger2.di.DaggerMyComponent;
import com.travelapp.retrofitdagger2.di.MyComponent;

public class MyApplication extends Application {
    private MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyComponent.builder()
                .aPIModule(new APIModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public MyComponent getComponent(){
        return component;
    }
}
