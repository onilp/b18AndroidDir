package com.calvert.retrofitrxjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.calvert.retrofitrxjava.model.WeatherResponse;
import com.calvert.retrofitrxjava.network.ApiInstance;
import com.calvert.retrofitrxjava.network.RetrofitInstance;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.edittext)
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        textView = findViewById(R.id.textView);
//        button = findViewById(R.id.button);
//        imageView = findViewById(R.id.imageView);
//        editText = findViewById(R.id.edittext);

        ApiInstance apiInstance = RetrofitInstance.getRetrofitInstance().create(ApiInstance.class);

/*        Call<WeatherResponse> call = apiInstance.getTodayWeather("London,uk", "b6907d289e10d714a6e88b30761fae22");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().getName());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });*/

        Observable<WeatherResponse> observable = apiInstance.getTodayWeather("London,uk", "b6907d289e10d714a6e88b30761fae22");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);  //lambda are supported in java8
    }

    private void handleResults(WeatherResponse weatherResponse) {
        Log.d(TAG, "handleResults: " + weatherResponse.toString());
    }

    private void handleError(Throwable throwable) {
        Log.d(TAG, "handleError: " + throwable.getMessage());
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        edittext.getText().toString();
    }
}
