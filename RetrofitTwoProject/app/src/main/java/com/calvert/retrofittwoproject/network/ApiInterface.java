package com.calvert.retrofittwoproject.network;

import com.calvert.retrofittwoproject.model.Comments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("comments")
    Call<List<Comments>> getComments();
}
