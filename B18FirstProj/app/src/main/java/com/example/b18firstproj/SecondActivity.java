package com.example.b18firstproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView secondActivityTextView;
    Button mainActivityButton, thirdActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondActivityTextView = findViewById(R.id.secondActivityTextView);
        mainActivityButton = findViewById(R.id.mainActivityButton);
        thirdActivityButton = findViewById(R.id.thirdActivityButton);

//        Bundle data = getIntent().getExtras();
//        String username = null;
//        if (data != null) {
//            username = data.getString("username");
//        }
        String username = getIntent().getExtras().getString("username");
        secondActivityTextView.setText(username);

        mainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

        thirdActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdActivityIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(thirdActivityIntent);
            }
        });
    }
}
