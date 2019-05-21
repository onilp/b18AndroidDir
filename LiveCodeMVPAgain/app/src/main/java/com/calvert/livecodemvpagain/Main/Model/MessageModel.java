package com.calvert.livecodemvpagain.Main.Model;

public class MessageModel {
    private String message;

    public MessageModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message + " got it from model";
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
