package ru.avtovokzal.driverspath.model;

import com.google.gson.annotations.SerializedName;

public class Carrier {

    @SerializedName("inn")
    public String mInn;

    @SerializedName("name")
    public String mName;

    public String getmInn() {
        return mInn;
    }

    public String getmName() {
        return mName;
    }
}
