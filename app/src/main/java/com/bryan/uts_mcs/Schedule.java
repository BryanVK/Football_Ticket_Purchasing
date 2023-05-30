package com.bryan.uts_mcs;

import android.os.Parcel;
import android.os.Parcelable;

public class Schedule implements Parcelable {
    private String match, date;
    private Integer image;

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.match);
        dest.writeString(this.date);
        dest.writeValue(this.image);
    }

    public void readFromParcel(Parcel source) {
        this.match = source.readString();
        this.date = source.readString();
        this.image = (Integer) source.readValue(Integer.class.getClassLoader());
    }

    public Schedule() {
    }

    protected Schedule(Parcel in) {
        this.match = in.readString();
        this.date = in.readString();
        this.image = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Schedule> CREATOR = new Creator<Schedule>() {
        @Override
        public Schedule createFromParcel(Parcel source) {
            return new Schedule(source);
        }

        @Override
        public Schedule[] newArray(int size) {
            return new Schedule[size];
        }
    };
}
