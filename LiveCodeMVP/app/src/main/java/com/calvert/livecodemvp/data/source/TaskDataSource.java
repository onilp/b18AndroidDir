package com.calvert.livecodemvp.data.source;

import com.calvert.livecodemvp.data.Task;

public interface TaskDataSource {

    interface GetTaskCallback{
        void onTaskLoaded(Task task);
    }

    void getTask(GetTaskCallback getTaskCallback);
}
