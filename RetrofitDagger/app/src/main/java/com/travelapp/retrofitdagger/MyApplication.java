package com.travelapp.retrofitdagger;

import android.app.Application;

import com.travelapp.retrofitdagger.di.APIModule;
import com.travelapp.retrofitdagger.di.DaggerMyComponent;
import com.travelapp.retrofitdagger.di.MyComponent;

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
