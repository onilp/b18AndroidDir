package com.example.recyclerviewsqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<DataModel> dataList;
    DbOperations operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operations = new DbOperations(this);
        operations.openDb();
        Cursor cursor = operations.readRow();

//        addRecord();
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

//    private void addRecord() {
//        dataList = new ArrayList<>();
//        dataList.add(new DataModel("Cal"));
//        dataList.add(new DataModel("Ben"));
//    }

    public void addToRecyclerView(View view) {
        EditText nameEditText = view.findViewById(R.id.name_edittext);
        operations.createRow(new DataModel(nameEditText.getText().toString()));
    }
}
