package com.example.secondcp;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri tasksUri = Uri.parse("content://com.example.minimalistcontentprovider.provider/words");
        Cursor cursor = getContentResolver().query(tasksUri,null,null,null,null);

        ListView tasksListView = findViewById(R.id.taskslistview);
        CursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,
                new String[]{"title","details"},new int[]{android.R.id.text1,android.R.id.text2},0);
        tasksListView.setAdapter(adapter);
    }
}

