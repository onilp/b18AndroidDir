package com.example.morecontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "WORDS.DB";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "words";
    public static final String ID = "_id";
    public static final String COLUMN_WORD = "word";
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_WORD + " TEXT);";


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
