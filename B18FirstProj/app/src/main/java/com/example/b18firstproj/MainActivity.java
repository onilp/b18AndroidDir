package com.example.b18firstproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if(username.equals("abc") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Successful login.", Toast.LENGTH_SHORT).show();
                    Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                    secondActivityIntent.putExtra("username", username);
                    startActivity(secondActivityIntent);
                }else{
                    Toast.makeText(MainActivity.this, "Wrong credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
