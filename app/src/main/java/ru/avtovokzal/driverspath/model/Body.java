package ru.avtovokzal.driverspath.model;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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
    public int mFreeseats;

    @DatabaseField(columnName = MAX_SEATS)
    @SerializedName("maxSeats")
    public int mMaxseats;

    @SerializedName("ticket")
    public List<Ticket> mTicket;


    @ForeignCollectionField(columnName = TICKETS, eager = true)
    public Collection<Ticket> mTickets = convertList();

    public Carrier getCarrier() {
        return mCarrier;
    }

    public int getFreeseats() {
        return mFreeseats;
    }

    public int getMaxseats() {
        return mMaxseats;
    }

    public List<Ticket> getTicket() {
        return mTicket;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {

        TableUtils.createTable(connectionSource, Body.class);
    }

    private Collection<Ticket> convertList() {

        Collection<Ticket> mTikets = new ArrayList<>();
        for (int i = 0; i < getTicket().size(); i++) {
            mTikets.add(getTicket().get(i));
        }
        return mTikets;
    }
}
