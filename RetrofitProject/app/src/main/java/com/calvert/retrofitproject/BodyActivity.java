package com.calvert.retrofitproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.calvert.retrofitproject.model.PageResponse;
import com.calvert.retrofitproject.model.User;
import com.calvert.retrofitproject.network.ApiInterface;
import com.calvert.retrofitproject.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BodyActivity extends AppCompatActivity {
    private static final String TAG = BodyActivity.class.getSimpleName();
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
                Call<User> call = apiInterface.sendUserDate(new User(101, "ooo@gmail.com", "Adam", "Jan", ""));

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.d(TAG, "onResponse: " + response.body());
                        User user = response.body();
                        Log.d(TAG, "UserResponse: " + user.getEmail().toString());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
    }
}
