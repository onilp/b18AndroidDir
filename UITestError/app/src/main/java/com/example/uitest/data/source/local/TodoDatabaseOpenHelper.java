package com.example.uitest.data.source.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * this class creates a db and its tables
 */
public class TodoDatabaseOpenHelper extends SQLiteOpenHelper {


    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    //create table tasks(_id integer primary key, taskid text, title text, details text)
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.TaskEntry.TABLE_NAME + " (" +
                    FeedReaderContract.TaskEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.TaskEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    FeedReaderContract.TaskEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    FeedReaderContract.TaskEntry.COLUMN_NAME_DETAILS+TEXT_TYPE+" )";


    public static final String DATABASE_NAME = "tasks.db";
    public static final int DATABASE_VERSION = 1;


    public TodoDatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //this method gets called for the first time when db is created and its tables need to be created
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if the user is migrating from version 1 to version 2
        //and ver 2 has two new columns
    }
}
