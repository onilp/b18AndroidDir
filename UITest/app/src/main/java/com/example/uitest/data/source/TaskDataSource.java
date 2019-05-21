package com.example.uitest.data.source;

public interface TaskDataSource {

    interface GetTaskCallback{
        void onTaskLoaded(Task task);
    }

    void getTask(GetTaskCallback callback);
}
