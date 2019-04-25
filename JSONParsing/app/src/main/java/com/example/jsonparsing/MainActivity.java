package com.example.jsonparsing;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<ContactModel> contactList = new ArrayList<>();

    private String TAG = MainActivity.class.getSimpleName();
    private ProgressDialog progressDialog;
    private static String url = "https://api.androidhive.info/contacts/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        GetContacts getContacts = new GetContacts();
        getContacts.execute();

    }

    private class GetContacts extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Getting contacts...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setCancelable(false);
            progressDialog.setProgress(0);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler httpHandler = new HttpHandler();

            String jsonString = httpHandler.makeServiceCall(url);

            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray contactsArray = jsonObject.getJSONArray("contacts");
                    progressDialog.setMax(contactsArray.length());
                    for (int i = 0; i < contactsArray.length(); i++) {
                        publishProgress(i+1);
                        Thread.sleep(1000);
                        JSONObject contactItems = contactsArray.getJSONObject(i);

                        String id = contactItems.getString("id");
                        String name = contactItems.getString("name");
                        String email = contactItems.getString("email");
                        String address = contactItems.getString("address");
                        String gender = contactItems.getString("gender");

                        JSONObject phone = contactItems.getJSONObject("phone");
                        String mobile = phone.getString("mobile");
                        String home = phone.getString("home");
                        String office = phone.getString("office");

                        ContactModel contactModel = new ContactModel(id, name, email, address, gender, mobile, home, office);
                        contactList.add(contactModel);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Error parsing JSON", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "No object is fetched", Toast.LENGTH_LONG).show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "Task completed!", Toast.LENGTH_SHORT).show();
            recyclerViewAdapter = new RecyclerViewAdapter(contactList);
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    }
}
