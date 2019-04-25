package com.example.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView pageHeaderTextView, usernameTextView, passwordTextView, genderTextView, smartTextView, healthyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pageHeaderTextView = findViewById(R.id.receivedPageHeaderTextView);
        usernameTextView = findViewById(R.id.receivedUsernameTextView);
        passwordTextView = findViewById(R.id.receivedPasswordTextView);
        genderTextView = findViewById(R.id.receivedGenderTextView);
        smartTextView = findViewById(R.id.receivedSmartTextView);
        healthyTextView = findViewById(R.id.receivedHealthyTextView);

        Bundle passedValues = getIntent().getExtras();
        String pageHeader = null;
        String username = null;
        String password = null;
        String gender = null;
        String smart = null;
        String healthy = null;
        if (passedValues != null) {
            pageHeader = passedValues.getString("pageHeader");
            username = passedValues.getString("username");
            password = passedValues.getString("password");
            gender = passedValues.getString("gender");
            smart = passedValues.getString("smart");
            healthy = passedValues.getString("healthy");
        }

        pageHeaderTextView.setText(pageHeader);
        usernameTextView.setText(username);
        passwordTextView.setText(password);
        genderTextView.setText(gender);
        smartTextView.setText(smart);
        healthyTextView.setText(healthy);
    }
}
