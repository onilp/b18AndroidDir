package com.example.recyclerviewmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, AdapterView.OnItemClickListener {
    RecyclerView firstNameRecyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<FirstNameModel> firstNameList = new ArrayList<>();
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(MainActivity.this);

        firstNameRecyclerView = findViewById(R.id.firstNameRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        firstNameRecyclerView.setLayoutManager(layoutManager);
        addToList();
        recyclerViewAdapter = new RecyclerViewAdapter(firstNameList, presenter);
        firstNameRecyclerView.setAdapter(recyclerViewAdapter);

}

    @Override
    public void addToList() {
        String[] firstName = getResources().getStringArray(R.array.first_name);
        for (String s : firstName) {
            firstNameList.add(new FirstNameModel(s));
        }
    }

    @Override
    public void showToast(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = (String) parent.getItemAtPosition(position);

        presenter.listItemClicked(name);
    }
}
