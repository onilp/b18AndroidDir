package com.calvert.livecodemvp.data.source;

import com.calvert.livecodemvp.data.source.local.TaskLocalDataSource;

public class TaskRepository implements TaskDataSource {

    TaskDataSource localTaskDataSource;

    public TaskRepository() {
        localTaskDataSource = new TaskLocalDataSource();
    }

    @Override
    public void getTask(GetTaskCallback getTaskCallback) {
        localTaskDataSource.getTask(getTaskCallback);
    }
}
