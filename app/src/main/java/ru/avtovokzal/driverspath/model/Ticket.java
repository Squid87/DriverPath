package ru.avtovokzal.driverspath.model;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

@DatabaseTable(tableName = Ticket.TABLE_NAME)
public class Ticket {

    public static final String TABLE_NAME = "ticket";
    private static final String COLUMN_ID = "_id";
    private static final String PRICE = "price";
    private static final String SEAT_NUMBER = "seat_number";
    private static final String DISPATCH_STATION_NAME = "dispatch_station_name";
    private static final String ARRIVAL_STATION_NAME = "arrival_station_name";
    private static final String PASSENGER = "passenger";


    @DatabaseField(columnName = COLUMN_ID, generatedId =  true)
    private int mId;

    @DatabaseField(columnName = PRICE)
    @SerializedName("price")
    public int mPrice;

    @SerializedName("agent")
    public String mAgent;

    @DatabaseField(columnName = SEAT_NUMBER)
    @SerializedName("seatNum")
    public int mSeatnum;

    @SerializedName("dispatchStationUid")
    public String mDispatchstationuid;

    @DatabaseField(columnName = DISPATCH_STATION_NAME)
    @SerializedName("dispatchStationName")
    public String mDispatchstationname;

    @SerializedName("arrivalStationUid")
    public String mArrivalstationuid;

    @DatabaseField(columnName = ARRIVAL_STATION_NAME)
    @SerializedName("arrivalStationName")
    public String mArrivalstationname;

    @DatabaseField(columnName = PASSENGER, foreign = true, foreignAutoRefresh = true)
    @SerializedName("passenger")
    public Passenger mPassenger;

    @SerializedName("ticketId")
    public String mTicketid;

    @SerializedName("ticketSeries")
    public String mTicketseries;

    @SerializedName("ticketNumber")
    public String mTicketnumber;

    public void setmId(int mId) {
        this.mId = mId;
    }

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

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Ticket.class);
    }
}
