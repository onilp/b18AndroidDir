package com.example.recyclerviewsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    static final String DATABASE_CREATE = "create table " + "names" + "( " + "_id" + " integer primary key autoincrement," + "name text);";

    public static final String DATABASE_NAME = "names.db";
    public static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, "names", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
