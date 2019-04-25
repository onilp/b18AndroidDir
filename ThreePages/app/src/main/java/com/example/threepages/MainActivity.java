package com.example.threepages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText loginUsernameEditText, loginPasswordEditText;
    Button loginButton;
    TextView redirectToRegisterTextView;
    Singleton singleton = Singleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginUsernameEditText = findViewById(R.id.loginUsernameEditText);
        loginPasswordEditText = findViewById(R.id.loginPasswordEditText);
        loginButton = findViewById(R.id.loginButton);
        redirectToRegisterTextView = findViewById(R.id.redirectToRegisterTextView);

        redirectToRegisterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this, Register.class);
                startActivity(registerIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginUsername = loginUsernameEditText.getText().toString();
                String loginPassword = loginPasswordEditText.getText().toString();

                if (!loginUsername.equals("") && !loginPassword.equals("")) {
                    Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
//                    homeIntent.putExtra("username", loginUsername);
//                    homeIntent.putExtra("password", loginPassword);
                    singleton.addToList(loginUsername);
                    startActivity(homeIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Wrong credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
