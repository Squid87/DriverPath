package ru.avtovokzal.driverspath.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

public class Ticket extends ExpandableGroup {

    public Ticket(String title, List items) {
        super(title, items);
    }


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

    public int getPrice() {
        return mPrice;
    }

    public int getSeatnum() {
        return mSeatnum;
    }

    public String getDispatchStationName() {
        return mDispatchstationname;
    }

    public String getArrivalStationName() {
        return mArrivalstationname;
    }

    public Passenger getPassenger() {
        return mPassenger;
    }

}
