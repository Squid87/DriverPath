package ru.avtovokzal.driverspath.stations.model;


import com.google.gson.annotations.SerializedName;

import ru.avtovokzal.driverspath.stations.model.StationResponse;


public class StationResponseBody {

    @SerializedName("body")
    public StationResponse mStationResponse = new StationResponse();

    public StationResponse getStationResponse() {
        return mStationResponse;
    }
}
