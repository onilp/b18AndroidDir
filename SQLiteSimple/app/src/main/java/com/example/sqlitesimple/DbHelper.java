package com.example.sqlitesimple;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    //db name
    public static final String DB_NAME = "PROFILE.DB";

    //table name
    public static final String TABLE_NAME = "USERS";

    //table columns
    public static final String _ID = " _id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    //database versiom
    static final int DB_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // creating table
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + EMAIL + " TEXT);";


    //execute the create table query
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
