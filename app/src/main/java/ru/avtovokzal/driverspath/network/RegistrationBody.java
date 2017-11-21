package ru.avtovokzal.driverspath.network;



public class RegistrationBody {

    public String date;
    public RouteKey routeKey = new RouteKey();

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
