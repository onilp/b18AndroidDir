package com.example.morecontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbOperations {
    private DbHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DbOperations(Context context) {
        this.context = context;
    }

    public DbOperations open() {
        dbHelper = new DbHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }


}
