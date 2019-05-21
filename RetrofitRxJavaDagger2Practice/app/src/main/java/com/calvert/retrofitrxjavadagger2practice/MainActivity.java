package com.calvert.retrofitrxjavadagger2practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.calvert.retrofitrxjavadagger2practice.model.UsersResponse;
import com.calvert.retrofitrxjavadagger2practice.network.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init component
        ((MyApplication)getApplication()).getComponent().injectRetrofit(this);

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        //call endpoint method of observable
        Observable<List<UsersResponse>> userObservable = apiInterface.getUsers();
        //subcribe with two methods using lamda
        //scheduler for background thread
        //mainthread for ui
        userObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(List<UsersResponse> usersResponse) {
        Log.d(TAG, "handleResults: " + usersResponse.toString());
    }

    private void handleError(Throwable throwable) {
        Log.d(TAG, "handleError: " + throwable.getMessage());
    }
}
