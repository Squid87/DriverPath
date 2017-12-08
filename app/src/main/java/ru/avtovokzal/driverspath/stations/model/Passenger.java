package ru.avtovokzal.driverspath.stations.model;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

@DatabaseTable(tableName = Passenger.TABLE_NAME)
public class Passenger {

	private static final String COLUMN_ID = "_id";
	public static final String TABLE_NAME = "passengerStation";
	private static final String GENDER = "gender";
	private static final String FIRST_NAME = "first_name";
	private static final String LAST_NAME = "last_name";
	private static final String MIDDLE_NAME = "middle_name";
	private static final String DOC_NUMBER = "doc_number";
	private static final String DOC_SERIES = "doc_series";
	private static final String DOC_TYPE_ID = "doc_type_id";
	private static final String BIRTHDAY = "birthday";
	private static final String CITIZENSHIP = "citizenship";

	@DatabaseField(columnName = COLUMN_ID, generatedId = true)
	private int mId;

	@DatabaseField(columnName = FIRST_NAME)
	@SerializedName("firstName")
	public String mFirstName;

	@DatabaseField(columnName = LAST_NAME)
	@SerializedName("lastName")
	public String mLastName;

	@DatabaseField(columnName = MIDDLE_NAME)
	@SerializedName("middleName")
	public String mMiddleName;

	@DatabaseField(columnName = DOC_NUMBER)
	@SerializedName("docNum")
	public String mDocNum;

	@DatabaseField(columnName = DOC_SERIES)
	@SerializedName("docSeries")
	public String mDocSeries;

	@DatabaseField(columnName = DOC_TYPE_ID)
	@SerializedName("docTypeId")
	public String mDocTypeId;

	@DatabaseField(columnName = BIRTHDAY)
	@SerializedName("birthday")
	public String mBirthday;

	@DatabaseField(columnName = CITIZENSHIP)
	@SerializedName("citizenshipISO2")
	public String mCitizenShip;

	@DatabaseField(columnName = GENDER)
	@SerializedName("gender")
	public String mGender;

	@SerializedName("phone")
	public String mPhone;

	@SerializedName("info")
	public String mInfo;

	public String getFirstName() {
		return mFirstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public String getMiddleName() {
		return mMiddleName;
	}

	public String getDocNum() {
		return mDocNum;
	}

	public String getDocSeries() {
		return mDocSeries;
	}

	public String getBirthday() {
		return mBirthday;
	}

	public String getCitizenShip() {
		return mCitizenShip;
	}

	public String getGender() {
		return mGender;
	}

	public String getDocTypeId() {
		return mDocTypeId;
	}

	public void setId(int mId) {
		this.mId = mId;
	}

	public static void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, Passenger.class);
	}
}
