package ru.avtovokzal.driverspath.modelStation;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;

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
    public Collection<In> mIn;

    @SerializedName("out")
    public Collection<Out> mOut;

    @SerializedName("order")
    public int mOrder;

    public String getName() {
        return mName;
    }

    public String getDispatchtime() {
        return mDispatchtime;
    }

    public Collection<In> getIn() {
        return mIn;
    }

    public Collection<Out> getOut() {
        return mOut;
    }

    public String getmArrivaltime() {
        return mArrivaltime;
    }
}
