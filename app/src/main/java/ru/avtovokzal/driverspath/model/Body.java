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

    public Carrier getCarrier() {
        return mCarrier;
    }

    public int getFreeseats() {
        return mFreeseats;
    }

    public int getMaxseats() {
        return mMaxseats;
    }

    public List<Ticket> getTicket() {
        return mTicket;
    }
}
