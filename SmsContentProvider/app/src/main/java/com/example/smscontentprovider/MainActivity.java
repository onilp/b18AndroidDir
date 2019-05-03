package com.example.smscontentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    ListView listView;
    int LOADER_ID = 007;
    Bundle instructions;
    CursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LoaderManager loaderManager = getSupportLoaderManager();
//        loaderManager.initLoader(LOADER_ID, instructions, this);

        listView = findViewById(R.id.listView);

        Uri uriSms = Uri.parse("content://sms/inbox");

        Cursor cursor = getContentResolver().query(uriSms, null, null, null, null);
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, new String[]{"body", "address"}, new int[]{android.R.id.text1, android.R.id.text2}, 0);

//        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,
//                null,
//                new String[]{
//                        "body", "address"
//                },
//                new int[]{
//                        android.R.id.text1, android.R.id.text2
//                },
//                0);
        listView.setAdapter(adapter);
    }

    public void contactPage(View view) {
        Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(intent);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        Uri uriSms = Uri.parse("content://sms/inbox");

        return new CursorLoader(this, uriSms, null, null, null, null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {
        adapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}

