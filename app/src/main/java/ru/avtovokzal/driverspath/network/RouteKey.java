package ru.avtovokzal.driverspath.network;


public class RouteKey {

    public String dispatchStationUid;
    public String arrivalStationUid;
    public String dispatchTime;

    public String getDispatchStationUid() {
        return dispatchStationUid;
    }

    public String getArrivalStationUid() {
        return arrivalStationUid;
    }

    public String getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchStationUid(String dispatchStationUid) {
        this.dispatchStationUid = dispatchStationUid;
    }

    public void setArrivalStationUid(String arrivalStationUid) {
        this.arrivalStationUid = arrivalStationUid;
    }

    public void setDispatchTime(String dispatchTime) {
        this.dispatchTime = dispatchTime;
    }
}
