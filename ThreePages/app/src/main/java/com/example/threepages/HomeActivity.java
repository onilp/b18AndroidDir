package com.example.threepages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView userRecyclerView;
    MyAdapter myAdapter;
//    List<Users> usersList = new ArrayList<>();
    List<Users> usersList = Singleton.getInstance().getUserList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userRecyclerView = findViewById(R.id.userRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        userRecyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter(usersList);
        userRecyclerView.setAdapter(myAdapter);

//        addUserRecord(getIntent().getExtras().getString("username"));
    }

//    private void addUserRecord(String username) {
//        Users user = new Users(username);
//        usersList.add(user);
//    }
}
