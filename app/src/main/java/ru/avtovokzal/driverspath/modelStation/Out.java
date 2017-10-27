package ru.avtovokzal.driverspath.modelStation;


import com.google.gson.annotations.SerializedName;

public class Out {

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

    @SerializedName("seatNum")
    public int mSeatnum;

    @SerializedName("agent")
    public String mAgent;

    @SerializedName("price")
    public int mPrice;

    public int getSeatnum() {
        return mSeatnum;
    }

    public String getDispatchstationname() {
        return mDispatchstationname;
    }

    public String getArrivalstationuid() {
        return mArrivalstationuid;
    }
}
