package com.example.sqlitesimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbOperations {
    private DbHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DbOperations(Context context) {
        this.context = context;
    }

    public DbOperations open() throws SQLException{
        dbHelper = new DbHelper(context);
        //open database connection
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void insert(String name, String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.NAME, name);
        contentValues.put(dbHelper.EMAIL, email);
        database.insert(dbHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor read(){
        String[] columns = new String[]{
                dbHelper._ID, dbHelper.NAME, dbHelper.EMAIL
        };

        Cursor cursor = database.query(dbHelper.TABLE_NAME, columns, null, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String name, String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.NAME, name);
        contentValues.put(dbHelper.EMAIL, email);
        int i = database.update(dbHelper.TABLE_NAME, contentValues, dbHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id){
        database.delete(dbHelper.TABLE_NAME, dbHelper._ID + " = " + _id, null);
    }
}
