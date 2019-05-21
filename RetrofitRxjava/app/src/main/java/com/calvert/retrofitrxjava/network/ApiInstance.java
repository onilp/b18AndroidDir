package com.calvert.retrofitrxjava.network;

import com.calvert.retrofitrxjava.model.WeatherResponse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInstance {

    @GET("weather?")
    Observable<WeatherResponse> getTodayWeather(@Query("q") String q, @Query("appid") String appid);
}
