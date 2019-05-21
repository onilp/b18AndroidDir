package com.calvert.observer;

public class MyEventClass {
    private String msg;

    public MyEventClass() {
    }

    public MyEventClass(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
