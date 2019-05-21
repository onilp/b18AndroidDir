package com.calvert.retrofitproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.calvert.retrofitproject.model.PageResponse;
import com.calvert.retrofitproject.network.ApiInterface;
import com.calvert.retrofitproject.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QueryActivity extends AppCompatActivity {
    private static final String TAG = QueryActivity.class.getSimpleName();
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
                Call<PageResponse> call = apiInterface.getPages("2");

                call.enqueue(new Callback<PageResponse>() {
                    @Override
                    public void onResponse(Call<PageResponse> call, Response<PageResponse> response) {
                        Log.d(TAG, "onResponse: " + response.body());
                        PageResponse pageResponse = response.body();
                        Log.d(TAG, "PageResponse: " + pageResponse.getTotal_pages().toString());
                        Log.d(TAG, "User" + pageResponse.getData().get(0).getLast_name());
                    }

                    @Override
                    public void onFailure(Call<PageResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
    }
}
