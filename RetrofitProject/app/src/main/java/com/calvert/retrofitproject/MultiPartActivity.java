package com.calvert.retrofitproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.calvert.retrofitproject.model.PageResponse;
import com.calvert.retrofitproject.network.ApiInterface;
import com.calvert.retrofitproject.network.RetrofitInstance;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultiPartActivity extends AppCompatActivity {
    private static final String TAG = MultiPartActivity.class.getSimpleName();
    private Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipart);

        //path of file you wanna use
        File file = new File("Desktop/download.png");

        // this parse all types of image file
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);

        //multipart from request body, 1st part
        final MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), requestBody);

        //description, 2nd part
        final RequestBody description = RequestBody.create(MediaType.get("text/plain"), "image-type");

        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
                Call call = apiInterface.uploadMultipart(part, description);

                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        Log.d(TAG, "onResponse: " + response.body());
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Log.d(TAG, "onFailure: " + t.getMessage());
                    }
                });
            }
        });
    }
}
