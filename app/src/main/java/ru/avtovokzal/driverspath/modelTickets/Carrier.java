package ru.avtovokzal.driverspath.modelTickets;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

@DatabaseTable(tableName = Carrier.TABLE_NAME)
public class Carrier {

    public static final String TABLE_NAME = "carrier";
    private static final String INN = "inn";
    private static final String NAME = "name";
    private static final String COLUMN_ID = "_id";

    @DatabaseField(columnName = COLUMN_ID, id = true)
    private int mId;

    @DatabaseField(columnName = INN)
    @SerializedName("inn")
    public String mInn;

    @DatabaseField(columnName = NAME)
    @SerializedName("name")
    public String mName;

    public String getInn() {
        return mInn;
    }

    public String getName() {
        return mName;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTable(connectionSource, Carrier.class);
    }
}
