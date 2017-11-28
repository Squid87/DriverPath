package ru.avtovokzal.driverspath.modelStation;

import android.database.Observable;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ru.avtovokzal.driverspath.modelTickets.Body;

@DatabaseTable(tableName = ru.avtovokzal.driverspath.modelStation.Passenger.TABME_NAME)
public class Passenger {

    private static final String COLUMN_ID = "_id";
    public static final String TABME_NAME = "passengerStation";
    private static final String GENDER = "gender";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String DOC_NUMBER = "doc_number";
    private static final String DOC_SERIES = "doc_series";
    private static final String DOC_TYPE_ID = "doc_type_id";
    private static final String BIRTHDAY = "birthday";
    private static final String CITIZENSHIP = "citizenship";
    private static final String PARENT_IN = "parent_in";
    private static final String PARENT_OUT = "parent_out";

    @DatabaseField(columnName = PARENT_IN, foreign = true)
    private In parentIn;

    @DatabaseField(columnName = PARENT_OUT, foreign = true)
    private Out parentOut;

    @DatabaseField(columnName = COLUMN_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = FIRST_NAME)
    @SerializedName("firstName")
    public String mFirstname;

    @DatabaseField(columnName = LAST_NAME)
    @SerializedName("lastName")
    public String mLastname;

    @DatabaseField(columnName = MIDDLE_NAME)
    @SerializedName("middleName")
    public String mMiddlename;

    @DatabaseField(columnName = DOC_NUMBER)
    @SerializedName("docNum")
    public String mDocnum;

    @DatabaseField(columnName = DOC_SERIES)
    @SerializedName("docSeries")
    public String mDocseries;

    @DatabaseField(columnName = DOC_TYPE_ID)
    @SerializedName("docTypeId")
    public String mDoctypeid;

    @DatabaseField(columnName = BIRTHDAY)
    @SerializedName("birthday")
    public String mBirthday;

    @DatabaseField(columnName = CITIZENSHIP)
    @SerializedName("citizenshipISO2")
    public String mCitizenshipiso2;

    @DatabaseField(columnName = GENDER)
    @SerializedName("gender")
    public String mGender;

    @SerializedName("phone")
    public String mPhone;

    @SerializedName("info")
    public String mInfo;

    public String getFirstname() {
        return mFirstname;
    }

    public String getLastname() {
        return mLastname;
    }

    public String getMiddlename() {
        return mMiddlename;
    }

    public String getDocnum() {
        return mDocnum;
    }

    public String getDocseries() {
        return mDocseries;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public String getCitizenshipiso2() {
        return mCitizenshipiso2;
    }

    public String getGender() {
        return mGender;
    }

    public String getDoctypeid() {
        return mDoctypeid;
    }

    public void setParentIn(In parentIn) {
        this.parentIn = parentIn;
    }

    public void setParentOut(Out parentOut) {
        this.parentOut = parentOut;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Passenger.class);
    }
}
