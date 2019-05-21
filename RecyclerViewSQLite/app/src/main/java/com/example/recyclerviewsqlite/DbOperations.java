package com.example.recyclerviewsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbOperations {
    SQLiteDatabase database;
    DbHelper helper;

    public DbOperations(Context context) {
        helper = new DbHelper(context);
    }

    public void openDb(){
        database = helper.getWritableDatabase();
    }

    public void closeDb(){
        database.close();
    }

    public void createRow(DataModel dataModel){
        ContentValues values = new ContentValues();
        values.put("names", dataModel.getName());

        database.insert("names", null, values);
    }

    public String readRow(){
        Cursor cursor = database.query("names", null, null, null, null, null, null);
        cursor.moveToLast();

        return "names";
    }

    public void updateRow(){}

    public void deleteRow(){}
}
