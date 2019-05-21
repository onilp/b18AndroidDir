package com.travelapp.retrofitdagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.travelapp.retrofitdagger2.di.APIModule;
import com.travelapp.retrofitdagger2.di.DaggerMyComponent;
import com.travelapp.retrofitdagger2.di.MyComponent;
import com.travelapp.retrofitdagger2.model.AlbumResponse;
import com.travelapp.retrofitdagger2.network.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Retrofit retrofit;
//    MyComponent myComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getComponent().injectRetrofit(this);

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<AlbumResponse>> call = apiInterface.getComments();

        call.enqueue(new Callback<List<AlbumResponse>>() {
            @Override
            public void onResponse(Call<List<AlbumResponse>> call, Response<List<AlbumResponse>> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<AlbumResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });    }
}
