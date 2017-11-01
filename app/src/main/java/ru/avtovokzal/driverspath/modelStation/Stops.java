package ru.avtovokzal.driverspath.modelStation;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

public class Stops {

    @SerializedName("name")
    public String mName;

    @SerializedName("uid")
    public String mUid;

    @SerializedName("dispatchTime")
    public String mDispatchtime;

    @SerializedName("arrivalTime")
    public String mArrivaltime;

    @SerializedName("in")
    public Collection<Ticket> mIn;

    @SerializedName("out")
    public Collection<Ticket> mOut;

    @SerializedName("order")
    public int mOrder;

    public String getName() {
        return mName;
    }

    public String getDispatchtime() {
        return mDispatchtime;
    }

    public Collection<Ticket> getIn() {
        return mIn;
    }

    public Collection<Ticket> getOut() {
        return mOut;
    }

    public String getmArrivaltime() {
        return mArrivaltime;
    }
}
