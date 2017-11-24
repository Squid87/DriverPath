package ru.avtovokzal.driverspath.network;


public class RouteKey {

    private String dispatchStationUid;
    private String arrivalStationUid;
    private String dispatchTime;

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
