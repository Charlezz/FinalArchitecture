package com.charlezz.javaapp.feature.main.remote;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    private long id;
    private long userId;
    private String title;
    private String body;

    public Post(long id, long userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeLong(this.userId);
        dest.writeString(this.title);
        dest.writeString(this.body);
    }

    protected Post(Parcel in) {
        this.id = in.readLong();
        this.userId = in.readLong();
        this.title = in.readString();
        this.body = in.readString();
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}

