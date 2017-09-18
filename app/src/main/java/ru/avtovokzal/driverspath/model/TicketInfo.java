package ru.avtovokzal.driverspath.model;


import com.google.gson.annotations.SerializedName;

public class TicketInfo {

    @SerializedName("body")
    public Body mBody;

    public Body getmBody() {
        return mBody;
    }
}
