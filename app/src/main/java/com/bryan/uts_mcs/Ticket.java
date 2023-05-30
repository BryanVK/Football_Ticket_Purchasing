package com.bryan.uts_mcs;

import android.os.Parcel;
import android.os.Parcelable;

public class Ticket implements Parcelable {
    private String match, date;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.match);
        dest.writeString(this.date);
    }

    public void readFromParcel(Parcel source) {
        this.match = source.readString();
        this.date = source.readString();
    }

    public Ticket() {
    }

    protected Ticket(Parcel in) {
        this.match = in.readString();
        this.date = in.readString();
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel source) {
            return new Ticket(source);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };
}
