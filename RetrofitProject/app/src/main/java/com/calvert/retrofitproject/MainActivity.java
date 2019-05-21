package com.calvert.retrofitproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.calvert.retrofitproject.model.PostResponse;
import com.calvert.retrofitproject.network.ApiInterface;
import com.calvert.retrofitproject.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
                Call<List<PostResponse>> call = apiInterface.getPosts();

                call.enqueue(new Callback<List<PostResponse>>() {
                    @Override
                    public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
                        Log.d(TAG, "onResponse: " + response.body().get(0).getTitle());

                    }

                    @Override
                    public void onFailure(Call<List<PostResponse>> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());

                    }

                });
            }
        });
    }
}
