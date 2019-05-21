package com.travelapp.retrofitdagger.network;

import com.travelapp.retrofitdagger.model.CommentsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("comments/")
    Call<List<CommentsResponse>> getComments();
}
