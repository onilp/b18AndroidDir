package com.travelapp.abercrombiefitchcodetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Observable<List<ShoppingModel>> shoppingModelObservable = apiInterface.getShopping();
        shoppingModelObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);
    }

    private void handleResult(List<ShoppingModel> shoppingModels) {
        Log.d(TAG, "handleResult: " + shoppingModels);
        recyclerViewAdapter = new RecyclerViewAdapter(shoppingModels, MainActivity.this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void handleError(Throwable throwable) {
        Log.d(TAG, "handleError: " +  throwable.getMessage());
    }

}
