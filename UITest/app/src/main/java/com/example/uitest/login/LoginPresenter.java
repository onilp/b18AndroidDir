package com.example.uitest.login;

import com.example.uitest.data.Task;
import com.example.uitest.data.source.TaskDataSource;
import com.example.uitest.data.source.local.TaskLocalDataSource;

public class LoginPresenter implements LoginContract.Presenter, TaskDataSource.GetTaskCallback {

    LoginContract.View view;
    TaskDataSource taskDataSource;

    public LoginPresenter(LoginActivity loginActivity)  {
        view = loginActivity;
        taskDataSource = new TaskLocalDataSource();
    }

    @Override
    public void buttonClicked() {
        taskDataSource.getTask(this);
    }

    @Override
    public void onTaskLoaded(Task task) {
        view.showAToast(task.getTaskTitle()+task.getTaskDetails());
    }
}
