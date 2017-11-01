package ru.avtovokzal.driverspath.modelStation;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Ticket implements Parcelable {

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

    public String getDispatchstationuid() {
        return mDispatchstationuid;
    }

    public String getArrivalstationuid() {
        return mArrivalstationuid;
    }

    public int getSeatnum() {
        return mSeatnum;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mSeatnum);
        parcel.writeString(mDispatchstationuid);
        parcel.writeString(mDispatchstationname);
        parcel.writeString(mArrivalstationuid);
        parcel.writeString(mArrivalstationname);
    }

    public static final Parcelable.Creator<ru.avtovokzal.driverspath.modelTickets.Ticket> CREATOR = new Parcelable.Creator<ru.avtovokzal.driverspath.modelTickets.Ticket>() {
        @Override
        public ru.avtovokzal.driverspath.modelTickets.Ticket createFromParcel(Parcel parcel) {
            ru.avtovokzal.driverspath.modelTickets.Ticket ticket = new ru.avtovokzal.driverspath.modelTickets.Ticket();
            ticket.mSeatnum = parcel.readInt();
            ticket.mDispatchstationuid = parcel.readString();
            ticket.mDispatchstationname = parcel.readString();
            ticket.mArrivalstationuid = parcel.readString();
            ticket.mArrivalstationname = parcel.readString();
            return ticket;
        }

        @Override
        public ru.avtovokzal.driverspath.modelTickets.Ticket[] newArray(int i) {
            return new ru.avtovokzal.driverspath.modelTickets.Ticket[i];
        }
    };

}
