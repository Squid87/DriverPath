package ru.avtovokzal.driverspath.mvp;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.avtovokzal.driverspath.Pref.Pref;
import ru.avtovokzal.driverspath.mvp.View.LoginView;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    private Pref mPref;

    public void startPath(String mDispatchCity, String mArriveCity) {
        String time, date;
        time = "11:30:00";
        date = "2017-09-10";
        mPref = new Pref();
        mPref.saveLogin(mDispatchCity, mArriveCity, time, date);
        getViewState().startTicket();
    }

}
