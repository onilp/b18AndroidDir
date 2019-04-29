package com.example.uitest.data;

public class Task {
    String taskTitle;
    String taskDetails;

    public Task(String taskTitle, String taskDetails) {
        this.taskTitle = taskTitle;
        this.taskDetails = taskDetails;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }
}
