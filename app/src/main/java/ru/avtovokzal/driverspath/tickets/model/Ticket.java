package ru.avtovokzal.driverspath.tickets.model;

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
    private static final String PARENT_BODY = "parent_body";

    @DatabaseField(columnName = PARENT_BODY, foreign = true)
    private Body parentBody;

    @DatabaseField(columnName = COLUMN_ID, id = true)
    private int mId;

    @DatabaseField(columnName = PRICE)
    @SerializedName("price")
    public int mPrice;

    @SerializedName("agent")
    public String mAgent;

    @DatabaseField(columnName = SEAT_NUMBER)
    @SerializedName("seatNum")
    public int mSeatNum;

    @SerializedName("dispatchStationUid")
    public String mDispatchStationId;

    @DatabaseField(columnName = DISPATCH_STATION_NAME)
    @SerializedName("dispatchStationName")
    public String mDispatchStationName;

    @SerializedName("arrivalStationUid")
    public String mArrivalStationId;

    @DatabaseField(columnName = ARRIVAL_STATION_NAME)
    @SerializedName("arrivalStationName")
    public String mArrivalStationName;

    @DatabaseField(columnName = PASSENGER, foreign = true, foreignAutoRefresh = true)
    @SerializedName("passenger")
    public Passenger mPassenger;

    @SerializedName("ticketId")
    public String mTicketId;

    @SerializedName("ticketSeries")
    public String mTicketSeries;

    @SerializedName("ticketNumber")
    public String mTicketNumber;

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getPrice() {
        return mPrice;
    }

    public int getSeatNum() {
        return mSeatNum;
    }

    public String getDispatchStationName() {
        return mDispatchStationName;
    }

    public String getArrivalStationName() {
        return mArrivalStationName;
    }

    public Passenger getPassenger() {
        return mPassenger;
    }

    public void setParentBodyId(Body parentBody) {
        this.parentBody = parentBody;
    }

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Ticket.class);
    }
}
