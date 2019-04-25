package com.example.parcelableproject;

import android.os.Parcel;
import android.os.Parcelable;

public class MyDetails implements Parcelable {

    String username, password;

    public MyDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected MyDetails(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<MyDetails> CREATOR = new Creator<MyDetails>() {
        @Override
        public MyDetails createFromParcel(Parcel in) {
            return new MyDetails(in);
        }

        @Override
        public MyDetails[] newArray(int size) {
            return new MyDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }
}
