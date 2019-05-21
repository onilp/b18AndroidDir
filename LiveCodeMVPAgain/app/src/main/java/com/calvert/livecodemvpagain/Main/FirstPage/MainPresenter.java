package com.calvert.livecodemvpagain.Main.FirstPage;

import com.calvert.livecodemvpagain.Main.Model.MessageModel;
import com.calvert.livecodemvpagain.Main.data.Task;
import com.calvert.livecodemvpagain.Main.data.source.TaskDataSource;
import com.calvert.livecodemvpagain.Main.data.source.local.TaskLocalDataSource;

public class MainPresenter implements MainContract.Presenter, TaskDataSource.TaskCallBack {

    MainContract.View view;
    MessageModel messageObject;

    TaskDataSource taskDataSource;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        taskDataSource = new TaskLocalDataSource();
    }

    @Override
    public void onSubmitClick(String msg) {
        messageObject = new MessageModel(msg);
        view.displayMessage(messageObject.getMessage());

        taskDataSource.getTask(this);

    }

    @Override
    public void onTaskLoadedFromDB(Task task) {
        view.displayMessage(task.getDetails());
    }
}
