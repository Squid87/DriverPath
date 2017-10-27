package ru.avtovokzal.driverspath.modelStation;


import com.google.gson.annotations.SerializedName;

import java.util.Collection;


public class StationResponse {

    @SerializedName("name")
    public String mName;

    @SerializedName("date")
    public String mDate;

    @SerializedName("stops")
    public Collection<Stops> mStops;

    @SerializedName("carrier")
    public Carrier mCarrier;

    @SerializedName("maxSeats")
    public int mMaxseats;

    public String getmName() {
        return mName;
    }

    public Collection<Stops> getStops() {
        return mStops;
    }

    public Carrier getmCarrier() {
        return mCarrier;
    }

}
