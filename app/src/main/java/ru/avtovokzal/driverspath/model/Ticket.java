package ru.avtovokzal.driverspath.model;

import com.google.gson.annotations.SerializedName;

public class Ticket {

    @SerializedName("price")
    public int mPrice;

    @SerializedName("agent")
    public String mAgent;

    @SerializedName("seatNum")
    public int mSeatnum;

    @SerializedName("dispatchStationUid")
    public String mDispatchstationuid;

    @SerializedName("dispatchStationName")
    public String mDispatchstationname;

    @SerializedName("arrivalStationUid")
    public String mArrivalstationuid;

    @SerializedName("arrivalStationName")
    public String mArrivalstationname;

    @SerializedName("passenger")
    public Passenger mPassenger;

    @SerializedName("ticketId")
    public String mTicketid;

    @SerializedName("ticketSeries")
    public String mTicketseries;

    @SerializedName("ticketNumber")
    public String mTicketnumber;
}
