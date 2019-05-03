package com.example.smsbirthday;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    //db name
    public static final String DB_NAME = "PROFILE.DB";
    //table name
    public static final String TABLE_NAME = "CONTACTS";
    //table columns
    public static final String ID = "_id";
    public static final String CONTACT_NAME = "name";
    public static final String BIRTHDAY = "birthday";
    //db version
    static final int DB_VERSION = 1;

    //create table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CONTACT_NAME + " TEXT NOT NULL, "
            + BIRTHDAY + " TEXT);";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
