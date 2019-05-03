package com.example.smsbirthday;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbOperations {
    DbHelper dbHelper;
    Context context;
    SQLiteDatabase database;

    public DbOperations(Context context) {
        this.context = context;
    }

    public DbOperations openDb(){
        dbHelper = new DbHelper(context);
        //open db connection
        database = dbHelper.getWritableDatabase();
        return this;
    }
}
