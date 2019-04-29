package com.example.uitest.addedittask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.uitest.R;
import com.example.uitest.data.Task;
import com.example.uitest.data.source.local.DatabaseOperations;

public class AddEditTaskActivity extends AppCompatActivity {

    private static final String TAG = AddEditTaskActivity.class.getSimpleName();
    DatabaseOperations operations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);
        operations = new DatabaseOperations(this);
        operations.openDb();
    }

    public void clickListener(View view) {
        switch (view.getId()){
            case R.id.buttonGet:
                Log.i(TAG,"getting data from db");
                break;
            case R.id.buttonSave:
                Log.i(TAG,"saving data to db");
                EditText titleEditText = findViewById(R.id.editTextTitle);
                EditText detailsEditText =  findViewById(R.id.editTextDetails);
                String title = titleEditText.getText().toString();
                String details = detailsEditText.getText().toString();

                Task task = new Task(title,details);
                operations.createRow(task);


                break;
        }
    }
}
