package ru.avtovokzal.driverspath.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {

    @SerializedName("carrier")
    public Carrier mCarrier;

    @SerializedName("freeSeats")
    public int mFreeseats;

    @SerializedName("maxSeats")
    public int mMaxseats;

    @SerializedName("ticket")
    public List<Ticket> mTicket;

    public Carrier getmCarrier() {
        return mCarrier;
    }

    public int getmFreeseats() {
        return mFreeseats;
    }

    public int getmMaxseats() {
        return mMaxseats;
    }

    public List<Ticket> getmTicket() {
        return mTicket;
    }
}
