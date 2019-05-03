package com.example.simplesharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        sp = getSharedPreferences("myFile", MODE_PRIVATE);

        editText.setText(sp.getString("username", ""));
    }

    public void storeSharedPreference(View view) {
        String data = editText.getText().toString();

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username", data);
        editor.commit();
    }
}
