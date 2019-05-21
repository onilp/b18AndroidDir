package com.example.uitest.data.source.local;

import android.content.Context;

import com.example.uitest.data.source.Task;
import com.example.uitest.data.source.TaskDataSource;

public class TaskLocalDataSource implements TaskDataSource {
    DatabaseOperations operations;

    public TaskLocalDataSource(Context context) {
        operations = new DatabaseOperations(context);
    }

    @Override
    public void getTask(GetTaskCallback callback) {
        Task task = new Task("rjt", "apolis");
        callback.onTaskLoaded(task);
    }
}
