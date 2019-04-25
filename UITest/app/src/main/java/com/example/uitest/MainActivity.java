package com.example.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendText(View view) {
        TextView textView = findViewById(R.id.textView);
        EditText editText = findViewById(R.id.editText);
        CheckBox checkBox = findViewById(R.id.checkBox);

        if(checkBox.isChecked()){
            textView.setText(editText.getText().toString() + " " + checkBox.getText().toString());
        }else{
            textView.setText(editText.getText().toString());
        }


    }
}
