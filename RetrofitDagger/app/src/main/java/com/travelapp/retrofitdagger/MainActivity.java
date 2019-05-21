package com.travelapp.retrofitdagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.travelapp.retrofitdagger.di.APIModule;
import com.travelapp.retrofitdagger.di.DaggerMyComponent;
import com.travelapp.retrofitdagger.di.MyComponent;
import com.travelapp.retrofitdagger.model.CommentsResponse;
import com.travelapp.retrofitdagger.network.ApiInterface;

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
//    MyComponent component;

//    https://jsonplaceholder.typicode.com/comments/1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        component = DaggerMyComponent.builder()
//                .aPIModule(new APIModule("https://jsonplaceholder.typicode.com/"))
//                .build();
//        component.injectRetrofit(this);
        ((MyApplication) getApplication()).getComponent().injectRetrofit(this);

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<CommentsResponse>> call = apiInterface.getComments();

        call.enqueue(new Callback<List<CommentsResponse>>() {
            @Override
            public void onResponse(Call<List<CommentsResponse>> call, Response<List<CommentsResponse>> response) {
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<CommentsResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
