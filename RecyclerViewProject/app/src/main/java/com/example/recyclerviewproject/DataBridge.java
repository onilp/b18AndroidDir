package com.example.recyclerviewproject;

import android.os.Parcel;
import android.os.Parcelable;

public class DataBridge implements Parcelable {

    String movieName, genre, year;

    public DataBridge(Parcel in) {
        movieName = in.readString();
        genre = in.readString();
        year = in.readString();
    }

    public DataBridge(String movieName, String genre, String year) {
        this.movieName = movieName;
        this.genre = genre;
        this.year = year;
    }

    public static final Creator<DataBridge> CREATOR = new Creator<DataBridge>() {
        @Override
        public DataBridge createFromParcel(Parcel in) {
            return new DataBridge(in);
        }

        @Override
        public DataBridge[] newArray(int size) {
            return new DataBridge[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString("movieName");
        dest.writeString("genre");
        dest.writeString("year");
    }
}
