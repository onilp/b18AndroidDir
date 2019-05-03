package com.example.uitest.data.source.local;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.uitest.data.Task;

/**
 * this class is responsible for create, read, update and delete
 * functionalities of the database
 */
public class DatabaseOperations {

    SQLiteDatabase database;
    TodoDatabaseOpenHelper helper;

    public DatabaseOperations(Context context){
        helper = new TodoDatabaseOpenHelper(context); // db gets created
    }

    public  void openDb(){
        database = helper.getWritableDatabase();//db is opened for writing
    }

    public  void closeDb(){
        database.close();
    }

    public  void createRow(Task task){
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.TaskEntry.COLUMN_NAME_TITLE,task.getTaskTitle());
        values.put(FeedReaderContract.TaskEntry.COLUMN_NAME_DETAILS,task.getTaskDetails());

        database.insert(FeedReaderContract.TaskEntry.TABLE_NAME,null,values);
    }

    public String readRow(){
        Cursor cursor = database.query(FeedReaderContract.TaskEntry.TABLE_NAME, null, null, null, null, null, null);

        int titleColIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.TaskEntry.COLUMN_NAME_TITLE);
        int detaildColIndex = cursor.getColumnIndexOrThrow(FeedReaderContract.TaskEntry.COLUMN_NAME_DETAILS);

        cursor.moveToLast();

        String title = cursor.getString(titleColIndex);
        String details = cursor.getString(detaildColIndex);

        return title + "\n" + details;
    }

    public void updateRow(){}
    public void deleteRow(){}
}
