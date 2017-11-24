package ru.avtovokzal.driverspath.modelStation;


import com.google.gson.annotations.SerializedName;


public class StationResponseBody {

    @SerializedName("body")
    public StationResponse mStationResponse = new StationResponse();

    public StationResponse getStationResponse() {
        return mStationResponse;
    }
}
