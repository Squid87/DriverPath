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
}
