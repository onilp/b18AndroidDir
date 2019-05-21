package com.calvert.livecodemvpagain.Main.data.source;

import com.calvert.livecodemvpagain.Main.data.Task;

public interface TaskDataSource {

    interface TaskCallBack {
        void onTaskLoadedFromDB(Task task);
    }

    void getTask(TaskCallBack callBack);
}
