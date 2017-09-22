package ru.avtovokzal.driverspath.model;

import com.google.gson.annotations.SerializedName;

public class Passenger {

    @SerializedName("info")
    public String mInfo;

    @SerializedName("phone")
    public String mPhone;

    @SerializedName("gender")
    public String mGender;

    @SerializedName("firstName")
    public String mFirstName;

    @SerializedName("lastName")
    public String mLastName;

    @SerializedName("middleName")
    public String mMiddleName;

    @SerializedName("docNum")
    public String mDocNum;

    @SerializedName("docSeries")
    public String mDocseries;

    @SerializedName("docTypeId")
    public String mDoctypeid;

    @SerializedName("birthday")
    public String mBirthday;

    @SerializedName("citizenshipISO2")
    public String mCitizenshipiso2;

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
        return mDocseries;
    }

    public String getDocTypeId() {
        return mDoctypeid;
    }

    public String getBirthday() {
        return mBirthday;
    }

    public String getCitizenship() {
        return mCitizenshipiso2;
    }

    public String getGender() {
        return mGender;
    }
}
