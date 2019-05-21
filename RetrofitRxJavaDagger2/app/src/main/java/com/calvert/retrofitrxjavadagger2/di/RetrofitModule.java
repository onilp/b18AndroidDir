package com.calvert.retrofitrxjavadagger2.di;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    //https://jsonplaceholder.typicode.com/albums/1
    private String baseUrl;

    public RetrofitModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    Retrofit providesRetrofitInstance(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

}
