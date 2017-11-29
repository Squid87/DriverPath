package ru.avtovokzal.driverspath.modelStation;

import com.google.gson.annotations.SerializedName;

public class StationTicket {

    public String direction;

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

    @SerializedName("isGone")
    public boolean mIsGone;

    public Passenger getPassenger() {
        return mPassenger;
    }

    public void setPassenger(Passenger passenger) {
        mPassenger = passenger;
    }

    public int getSeatnum() {
        return mSeatnum;
    }

    public String getTicketId() {
        return mTicketid;
    }

    public boolean isGone() {
        return mIsGone;
    }

    public void setIsGone(boolean mIsGone) {
        this.mIsGone = mIsGone;
    }

    public void setTicketId(String mTicketid) {
        this.mTicketid = mTicketid;
    }
}
