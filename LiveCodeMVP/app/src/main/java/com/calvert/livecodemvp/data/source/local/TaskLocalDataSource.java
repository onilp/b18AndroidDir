package com.calvert.livecodemvp.data.source.local;

import com.calvert.livecodemvp.data.Task;
import com.calvert.livecodemvp.data.source.TaskDataSource;

/**
 * query local db
 */
public class TaskLocalDataSource implements TaskDataSource {

    public TaskLocalDataSource() {
    }

    @Override
    public void getTask(GetTaskCallback getTaskCallback) {
        Task task = new Task("myTitle", "myDetails");
        getTaskCallback.onTaskLoaded(task); // 3, go to main presenter
    }
}
