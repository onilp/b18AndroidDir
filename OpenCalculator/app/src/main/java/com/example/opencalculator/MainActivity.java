package com.example.opencalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView openCalculatorTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openCalculatorTextView = findViewById(R.id.openCalculatorTextView);

        openCalculatorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent openCalculatorIntent = new Intent(Intent.CATEGORY_APP_CALCULATOR);
//                startActivity(openCalculatorIntent);
                Intent intent = new Intent();
                intent.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                startActivity(intent);
                Log.i("testing log", "this is an example log i");
            }
        });
    }
}
