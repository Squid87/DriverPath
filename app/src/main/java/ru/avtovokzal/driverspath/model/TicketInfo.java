package ru.avtovokzal.driverspath.model;


import com.arellomobile.mvp.MvpView;
import com.google.gson.annotations.SerializedName;

public class TicketInfo {

    @SerializedName("body")
    public Body mBody;

    public Body getBody() {
        return mBody;
    }
}
