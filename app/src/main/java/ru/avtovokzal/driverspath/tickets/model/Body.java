package ru.avtovokzal.driverspath.tickets.model;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Collection;


@DatabaseTable(tableName = Body.TABLE_NAME)
public class Body {

    public static final String TABLE_NAME = "body";
    private static final String COLUMN_ID = "_id";
    private static final String CARRIER = "carrier";
    private static final String FREE_SEATS = "free_seats";
    private static final String MAX_SEATS = "max_seats";
    private static final String TICKETS = "tickets";


    @DatabaseField(columnName = COLUMN_ID, id = true)
    private int mId;

    @DatabaseField(columnName = CARRIER, foreign = true, foreignAutoRefresh = true)
    @SerializedName("carrier")
    public Carrier mCarrier;

    @DatabaseField(columnName = FREE_SEATS)
    @SerializedName("freeSeats")
    public int mFreeSeats;

    @DatabaseField(columnName = MAX_SEATS)
    @SerializedName("maxSeats")
    public int mMaxSeats;

    @ForeignCollectionField(columnName = TICKETS, eager = true)
    @SerializedName("ticket")
    public Collection<Ticket> mTicket;


    public Carrier getCarrier() {
        return mCarrier;
    }

    public int getFreeSeats() {
        return mFreeSeats;
    }

    public int getMaxSeats() {
        return mMaxSeats;
    }

    public Collection<Ticket> getTicket() {
        return mTicket;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public int getId() {
        return mId;
    }

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTable(connectionSource, Body.class);
    }

}
