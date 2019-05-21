package com.calvert.livecodemvp.FirstPage;

import com.calvert.livecodemvp.TextModel;
import com.calvert.livecodemvp.data.Task;
import com.calvert.livecodemvp.data.source.TaskDataSource;
import com.calvert.livecodemvp.data.source.TaskRepository;
import com.calvert.livecodemvp.data.source.local.TaskLocalDataSource;

public class MainPresenter implements MainContract.Presenter, TaskDataSource.GetTaskCallback {
    private TaskDataSource taskDataSource;
    private MainContract.View view;
    private TextModel textModel;

    MainPresenter(MainContract.View view) {
        this.view = view;
//        taskDataSource = new TaskLocalDataSource();
        taskDataSource = new TaskRepository();
    }

    @Override
    public void onSubmitClicked(String msg) {
//        textModel = new TextModel(msg);
//        view.displayMessage(textModel.getMessage());

        taskDataSource.getTask(this);  // 2, go to tasklocaldatasource
    }

    @Override
    public void onTaskLoaded(Task task) {
        view.displayMessage(task.getDetails());  // 4, go to main activity
    }
}
