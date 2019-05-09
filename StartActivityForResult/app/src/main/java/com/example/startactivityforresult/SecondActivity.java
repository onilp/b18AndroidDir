package com.example.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.edittext);

    }

    public void secondClick(View view) {
        Intent mainIntent = new Intent();
        mainIntent.putExtra("data", editText.getText().toString());

        setResult(RESULT_OK, mainIntent);
        finish();
    }
}
