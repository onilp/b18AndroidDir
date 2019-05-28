package com.calvert.retrofithomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.calvert.retrofithomework.model.Photo;
import com.calvert.retrofithomework.network.ApiInterface;
import com.calvert.retrofitlibrary.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRetrofit extends AppCompatActivity {

    private static final String TAG = PhotoRetrofit.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_retrofit);

        ApiInterface apiInterface = RetrofitInstance.getInstance("https://jsonplaceholder.typicode.com/").create(ApiInterface.class);
        Call<List<Photo>> call = apiInterface.getPhoto();

        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                Log.d(TAG, "onResponse: " + response.body().get(0).getAlbumId());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

        Call<List<Photo>> call2 = apiInterface.getSinglePhoto("1");
        call2.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                Log.d(TAG, "Single photo: " + response.body());
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.d(TAG, "Single Fail: " + t.getMessage());
            }
        });
    }
}
