package ru.avtovokzal.driverspath.modelStation;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ru.avtovokzal.driverspath.modelTickets.Body;

import static ru.avtovokzal.driverspath.modelStation.In.IN_PEOPLE;

@DatabaseTable(tableName = IN_PEOPLE)
public class In {

    public static final String IN_PEOPLE = "in_people";
    private static final String DISPATCH_STATION = "dispatch_station";
    private static final String ARRIVE_STATION = "arrive_station";
    private static final String SEAT_NUMBER = "seat_number";
    private static final String PARENT_STOPS = "parent_stops";
    private static final String COLUMN_ID = "_id";
    private static final String MISGONE = "misgone";


    @DatabaseField(columnName = COLUMN_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = PARENT_STOPS, foreign = true)
    private Stops mParentStops;

    @SerializedName("dispatchStationUid")
    public String mDispatchstationuid;

    @DatabaseField(columnName = DISPATCH_STATION)
    @SerializedName("dispatchStationName")
    public String mDispatchstationname;

    @SerializedName("arrivalStationUid")
    public String mArrivalstationuid;

    @DatabaseField(columnName = ARRIVE_STATION)
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

    @DatabaseField(columnName = SEAT_NUMBER)
    @SerializedName("seatNum")
    public int mSeatnum;

    @SerializedName("agent")
    public String mAgent;

    @SerializedName("price")
    public int mPrice;

    @DatabaseField(columnName = MISGONE)
    @SerializedName("isGone")
    public boolean misGone;

    public void setParentStops(Stops parentStops) {
        this.mParentStops = parentStops;
    }

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, In.class);
    }
}
