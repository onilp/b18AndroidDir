package com.example.listviewproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    String[] countryArr = {"India", "China", "USA", "Japan", "UK", "Nepal", "India", "China", "USA", "Japan", "UK", "Nepal"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryArr);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_layout, R.id.textView, countryArr);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemStr = (String) parent.getItemAtPosition(position);
                String location = null;
                switch (itemStr) {
                    case "India":
                        location = "geo:0,0?q=India";
                        break;

                    case "China":
                        location = "geo:0,0?q=China";
                        break;

                    case "USA":
                        location = "geo:0,0?q=USA";
                        break;
                }

//                Intent mapActivity = new Intent(MainActivity.this, MapActivity.class);
//                startActivity(mapActivity);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                startActivity(mapIntent);
//                Toast.makeText(MainActivity.this, "This is my id: " + id + " Position: " + position + " " + itemStr, Toast.LENGTH_LONG).show();
            }
        });

    }
}
