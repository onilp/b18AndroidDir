package com.calvert.livecodemvp;

public class TextModel {
    String message;

    public TextModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message + " message from model";
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
