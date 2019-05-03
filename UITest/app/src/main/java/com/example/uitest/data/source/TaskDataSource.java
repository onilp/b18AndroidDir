package com.example.uitest.data.source;

import com.example.uitest.data.Task;

public interface TaskDataSource {

    interface GetTaskCallback{
        void onTaskLoaded(Task task);
    }

    void getTask(GetTaskCallback callback);
}
