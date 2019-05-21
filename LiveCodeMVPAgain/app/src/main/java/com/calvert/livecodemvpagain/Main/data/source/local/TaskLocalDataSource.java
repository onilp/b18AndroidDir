package com.calvert.livecodemvpagain.Main.data.source.local;

import com.calvert.livecodemvpagain.Main.data.Task;
import com.calvert.livecodemvpagain.Main.data.source.TaskDataSource;

public class TaskLocalDataSource implements TaskDataSource {
    @Override
    public void getTask(TaskCallBack callBack) {
        Task task = new Task("title", "details");
        callBack.onTaskLoadedFromDB(task);  //this task should be fetched from the db
    }
}
