package com.example.b18fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PassingDataActivityStaticFrags extends AppCompatActivity implements LoginDataInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_data_static_frags);
    }

    @Override
    public void loginData(String username, String password) {
        FragmentTwo fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentById(R.id.readLoginInputFragment);
        fragmentTwo.getMyData(username, password);
    }
}
