package com.example.sqlitesimple;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText, emailEditText;
    Button saveButton;
    DbOperations dbOperations;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name_edittext);
        emailEditText = findViewById(R.id.email_edittext);
        listView = findViewById(R.id.listview);
    }

    public void SaveData(View view) {
        dbOperations = new DbOperations(this);
        dbOperations.open();
        dbOperations.insert(nameEditText.getText().toString(), emailEditText.getText().toString());

        Cursor cursor = dbOperations.read();
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, new String[] {"name", "email"}, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        listView.setAdapter(adapter);
    }
}
