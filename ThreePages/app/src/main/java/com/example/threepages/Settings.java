package com.example.threepages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    TextView usernameSettingsTextView, passwordSettingsTextView, genderSettingsTextView, occupationSettingsTextView;
    Button logoutSettingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        usernameSettingsTextView = findViewById(R.id.usernameSettingsTextView);
        passwordSettingsTextView = findViewById(R.id.passwordSettingsTextView);
        genderSettingsTextView = findViewById(R.id.genderSettingsTextView);
        occupationSettingsTextView = findViewById(R.id.occupationSettingsTextView);
        logoutSettingsButton = findViewById(R.id.logoutSettingsButton);

        usernameSettingsTextView.setText(getIntent().getExtras().getString("username"));
        passwordSettingsTextView.setText(getIntent().getExtras().getString("password"));
        genderSettingsTextView.setText(getIntent().getExtras().getString("gender"));
        occupationSettingsTextView.setText(getIntent().getExtras().getString("occupation"));

        logoutSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(Settings.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });
    }
}
