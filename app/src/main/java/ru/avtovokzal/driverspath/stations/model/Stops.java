package ru.avtovokzal.driverspath.stations.model;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Collection;

import static ru.avtovokzal.driverspath.stations.model.Stops.STOPS;

@DatabaseTable(tableName = STOPS)
public class Stops {

    public static final String STOPS = "stops";
    private static final String STATION_NAME = "station_name";
    private static final String DISPATCH_TIME = "dispatch_time";
    private static final String OUT_PEOPLE = "out_people";
    private static final String IN_PEOPLE = "in_people";
    private static final String COLUMN_ID = "_id";

    @DatabaseField(columnName = COLUMN_ID, id = true)
    private int mId;

    @DatabaseField(columnName = STATION_NAME)
    @SerializedName("name")
    public String mName;

    @SerializedName("uid")
    public String mUid;

    @DatabaseField(columnName = DISPATCH_TIME)
    @SerializedName("dispatchTime")
    public String mDispatchTime;

    @SerializedName("arrivalTime")
    public String mArrivalTime;

    @ForeignCollectionField(columnName = IN_PEOPLE, eager = true)
    @SerializedName("in")
    public Collection<In> mIn;

    @ForeignCollectionField(columnName = OUT_PEOPLE, eager = true)
    @SerializedName("out")
    public Collection<Out> mOut;

    @SerializedName("order")
    public int mOrder;

    public String getName() {
        return mName;
    }

    public String getDispatchTime() {
        return mDispatchTime;
    }

    public Collection<In> getIn() {
        return mIn;
    }

    public Collection<Out> getOut() {
        return mOut;
    }

    public String getArrivalTime() {
        return mArrivalTime;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Stops.class);
    }
}
