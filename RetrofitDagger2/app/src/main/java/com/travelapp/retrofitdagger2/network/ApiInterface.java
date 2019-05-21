package com.travelapp.retrofitdagger2.network;

import com.travelapp.retrofitdagger2.model.AlbumResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("albums/")
    Call<List<AlbumResponse>> getComments();
}
