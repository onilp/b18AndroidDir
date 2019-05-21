package com.calvert.retrofithomework.network;

import com.calvert.retrofithomework.model.Album;
import com.calvert.retrofithomework.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("albums/")
    Call<List<Album>> getAlbum();

    @GET("photos/")
    Call<List<Photo>> getPhoto();

    @GET("photos?")
    Call<List<Photo>> getSinglePhoto(@Query("id") String id);
}
