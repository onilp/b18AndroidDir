package com.calvert.retrofitproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.calvert.retrofitproject.model.User;
import com.calvert.retrofitproject.network.ApiInterface;
import com.calvert.retrofitproject.network.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FieldActivity extends AppCompatActivity {
    private static final String TAG = FieldActivity.class.getSimpleName();
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field);

        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
                Call<User> call = apiInterface.setUserData("Jane", "Marc");

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.d(TAG, "onResponse: " + response.body());
                        User user = response.body();
                        Log.d(TAG, "Field response: " + user.getLast_name());
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
