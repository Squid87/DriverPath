package ru.avtovokzal.driverspath.Pref;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import ru.avtovokzal.driverspath.Application;

public class Pref {

    private java.util.Date mDate = new java.util.Date();
    private final SharedPreferences mSharedPreferences;
    private String KEY_TIME = "KEY_TIME";
    private String KEY_ARRIVE_STATION = "KEY_ARRIVE_STATION";
    private String KEY_DISPATCH_STATION = "KEY_DISPATCH_STATION";
    private String KEY_DISPATCH_TIME = "KEY_DISPATCH_TIME";
    private String KEY_DATE = "KEY_DATE";


    public Pref() {
        mSharedPreferences = Application.getInstance().getSharedPreferences("ru.avtovokzal.driverpath", Context.MODE_PRIVATE);
    }


    @SuppressLint("ApplySharedPref")
    public void saveTime(long time) {
        mSharedPreferences.edit().putLong(KEY_TIME, time).commit();

    }

    public long loadTime() {
        return mSharedPreferences.getLong(KEY_TIME, mDate.getTime());
    }

    @SuppressLint("ApplySharedPref")
    public void saveLogin(String dispatchStation, String arriveStation, String time, String date) {
        mSharedPreferences.edit().putString(KEY_DISPATCH_STATION, dispatchStation).commit();
        mSharedPreferences.edit().putString(KEY_ARRIVE_STATION, arriveStation).commit();
        mSharedPreferences.edit().putString(KEY_DISPATCH_TIME, time).commit();
        mSharedPreferences.edit().putString(KEY_DATE, date).commit();
    }

    public String loadArriveStation() {
        return mSharedPreferences.getString(KEY_ARRIVE_STATION, "");
    }

    public String loadDispatchStation() {
        return mSharedPreferences.getString(KEY_DISPATCH_STATION, "");
    }

    public String loadDispatchTime() {
        return mSharedPreferences.getString(KEY_DISPATCH_TIME, "");
    }

    public String loadDate() {
        return mSharedPreferences.getString(KEY_DATE, "");
    }


}
