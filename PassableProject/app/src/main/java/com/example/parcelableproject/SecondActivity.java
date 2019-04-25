package com.example.parcelableproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.passableproject.R;

public class SecondActivity extends AppCompatActivity {

    TextView usernameTextView, passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        usernameTextView = findViewById(R.id.usernameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

        MyDetails myDetails = getIntent().getParcelableExtra("loginObject");
        usernameTextView.setText(myDetails.username);
        passwordTextView.setText(myDetails.password);

    }
}
