package com.example.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button app2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app2 = findViewById(R.id.app2);

        app2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent app2 = new Intent("App2");
                startActivity(app2);
            }
        });
    }
}
