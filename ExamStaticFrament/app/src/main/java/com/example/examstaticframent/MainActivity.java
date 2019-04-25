package com.example.examstaticframent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements UsernameInterface {

    UsernameInterface usernameInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void storedUsername(String username) {
        OutputFragment outputFragment = (OutputFragment) getSupportFragmentManager().findFragmentById(R.id.outputFragment);
        outputFragment.getData(username);
    }
}
