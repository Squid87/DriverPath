package ru.avtovokzal.driverspath.Pref;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import ru.avtovokzal.driverspath.Application;

public class Pref {

    private java.util.Date mDate = new java.util.Date();
    private final SharedPreferences mSharedPreferences;
    private String KEY_TIME = "KEY_TIME";

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
}
