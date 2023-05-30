package com.bryan.uts_mcs;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {
    private String headline, desc, date;
    private Integer photo;

    public News() {

    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.headline);
        dest.writeString(this.desc);
        dest.writeString(this.date);
        dest.writeValue(this.photo);
    }

    public void readFromParcel(Parcel source) {
        this.headline = source.readString();
        this.desc = source.readString();
        this.date = source.readString();
        this.photo = (Integer) source.readValue(Integer.class.getClassLoader());
    }

    protected News(Parcel in) {
        this.headline = in.readString();
        this.desc = in.readString();
        this.date = in.readString();
        this.photo = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
