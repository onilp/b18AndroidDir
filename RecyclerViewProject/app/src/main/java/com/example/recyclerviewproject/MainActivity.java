package com.example.recyclerviewproject;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView movieRecyclerView;
    MyAdapter myAdapter;
    List<Movies> moviesList = new ArrayList<>();
    ProgressDialog progressDialog;
    String url = "https://api.androidhive.info/contacts/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerView = findViewById(R.id.movieRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        movieRecyclerView.setLayoutManager(layoutManager);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Downloading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    progressDialog.cancel();
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("contacts");

                    for(int i=0; i<jsonArray.length(); i++){
                        JSONObject contacts = jsonArray.getJSONObject(i);

                        String name = contacts.getString("name");
                        String email = contacts.getString("email");
                        String gender = contacts.getString("gender");

                        moviesList.add(new Movies(name,email, gender));
                    }

                    myAdapter = new MyAdapter(moviesList);
                    movieRecyclerView.setAdapter(myAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
//        addRecords();
    }

    private void addRecords() {
        Movies m = new Movies("Avenger", "Action", "2019");
        moviesList.add(m);
        Movies m1 = new Movies("Avenger2", "Action", "2020");
        moviesList.add(m1);
        Movies m2 = new Movies("Avenger3", "Action", "2021");
        moviesList.add(m2);
        Movies m3 = new Movies("Avenger4", "Action", "2022");
        moviesList.add(m3);
    }

}
