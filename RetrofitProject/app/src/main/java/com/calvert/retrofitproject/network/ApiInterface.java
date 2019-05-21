package com.calvert.retrofitproject.network;

import com.calvert.retrofitproject.model.PageResponse;
import com.calvert.retrofitproject.model.PostResponse;
import com.calvert.retrofitproject.model.User;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("posts/")
    Call<List<PostResponse>> getPosts();

    @GET("users?")
    Call<PageResponse> getPages(@Query("page") String page);

    @POST("users?")
    Call<User> sendUserDate(@Body User user);

    //@Field works with POST only
    //whenever we use field then use @FormUrlEncoded
    @FormUrlEncoded
    @POST("users?")
    Call<User> setUserData(@Field("first_name") String firstName, @Field("last_name") String lastName);

    // file --> file
    //request body --> type of file
    @Multipart
    @POST("/upload")
    Call<User> uploadMultipart(@Part MultipartBody.Part file, @Part("name")RequestBody requestBody);
}
