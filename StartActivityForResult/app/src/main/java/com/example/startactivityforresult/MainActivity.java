package com.example.startactivityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mainClick(View view) {
        Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(secondActivityIntent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        TextView textView = findViewById(R.id.textview);
        if(resultCode == RESULT_OK){
            textView.setText(intent.getExtras().getString("data"));
        }
    }
}
