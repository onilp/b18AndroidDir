package com.example.b18fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PassingDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data);

        getSupportFragmentManager().beginTransaction().add(R.id.mylayout,new FragmentOne()).commit();
    }
}