package com.example.parcelableproject;

import android.os.Parcel;
import android.os.Parcelable;

public class LoginDetails implements Parcelable {

    String username, password;

    public LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieving data from the parcel object
     * @param in
     */

    protected LoginDetails(Parcel in) {
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<LoginDetails> CREATOR = new Creator<LoginDetails>() {
        @Override
        public LoginDetails createFromParcel(Parcel in) {
            return new LoginDetails(in);
        }

        @Override
        public LoginDetails[] newArray(int size) {
            return new LoginDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Store login details data to the parcel object
     * @param dest
     * @param flags
     */

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
    }
}
