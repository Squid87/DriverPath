package ru.avtovokzal.driverspath.modelStation;

import com.google.gson.annotations.SerializedName;

public class Passenger {

    @SerializedName("firstName")
    public String mFirstname;

    @SerializedName("lastName")
    public String mLastname;

    @SerializedName("middleName")
    public String mMiddlename;

    @SerializedName("docNum")
    public String mDocnum;

    @SerializedName("docSeries")
    public String mDocseries;

    @SerializedName("docTypeId")
    public String mDoctypeid;

    @SerializedName("birthday")
    public String mBirthday;

    @SerializedName("citizenshipISO2")
    public String mCitizenshipiso2;

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
}
