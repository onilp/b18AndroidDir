package com.example.parcelableproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView usernameTextView, passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        usernameTextView = findViewById(R.id.usernameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

        LoginDetails loginDetails = getIntent().getParcelableExtra("loginCredentialsObject");
        /**
         * objectName.objectKey will return the object value
         *
         * objectName: loginDetails
         * objectKey: username, password
         */
        usernameTextView.setText(loginDetails.username);
        passwordTextView.setText(loginDetails.password);
    }
}
