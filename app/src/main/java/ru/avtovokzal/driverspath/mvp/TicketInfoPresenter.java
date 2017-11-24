package ru.avtovokzal.driverspath.mvp;

import android.util.Base64;
import android.view.Gravity;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;

import retrofit2.Response;
import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.Pref.Pref;
import ru.avtovokzal.driverspath.database.DatabaseHelper;
import ru.avtovokzal.driverspath.database.DatabaseService;
import ru.avtovokzal.driverspath.modelTickets.RegistrationResponse;
import ru.avtovokzal.driverspath.mvp.View.TicketInformationView;
import ru.avtovokzal.driverspath.network.RegistrationBody;
import ru.avtovokzal.driverspath.network.ApiService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class TicketInfoPresenter extends MvpPresenter<TicketInformationView> {

    private java.util.Date mDate = new java.util.Date();
    private String BASE_URL = "http://webapp.avtovokzal.ru";
    private DatabaseService mDatabaseService = new DatabaseService(Application.getInstance());
    private DatabaseHelper mDatabaseHelper = new DatabaseHelper(Application.getInstance());
    public ApiService mApiService = ApiService.getsInstance(Application.getInstance(), BASE_URL);
    private Pref mPref = new Pref();


    public void startLoad() {
        rx.Observable.fromCallable(this::requestTicketInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.repeatWhen(completed -> completed.delay(10, TimeUnit.MINUTES))
                .subscribe(new Subscriber<Response<RegistrationResponse>>() {

                    @Override
                    public void onCompleted() {
                        getViewState().hideProgressBar();
                        mPref.saveTime(mDate.getTime());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().hideProgressBar();
                        Toast toast = Toast.makeText(Application.getInstance(),
                                "Данные загружены из Базы данных!", Toast.LENGTH_LONG);
                        toast.show();
                        toast.setGravity(Gravity.CENTER, 0, 0);

                        try {
                            getViewState().showTicketInfo(mDatabaseService.loadTickets());
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }

                    @Override
                    public void onNext(Response<RegistrationResponse> response) {
                        getViewState().showProgressBar();
                        RegistrationResponse registrationResponse = response.body();
                        try {
                            if (mDatabaseHelper.getBodyDao().idExists(1)) {
                                long m = mDate.getTime();
                                long s = mPref.loadTime();
                                if (m - s < 300000) {
                                    getViewState().showTicketInfo(mDatabaseService.loadTickets());
                                } else {
                                    mDatabaseService.deleteDatabaseTicket();
                                    getViewState().showTicketInfo(registrationResponse.getBody());
                                    mDatabaseService.saveTickets(registrationResponse.getBody());
                                }
                            } else {
                                getViewState().showTicketInfo(registrationResponse.getBody());
                                mDatabaseService.saveTickets(registrationResponse.getBody());
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private Response<RegistrationResponse> requestTicketInfo() throws IOException {

        RegistrationBody body = new RegistrationBody();
        body.routeKey.setDispatchStationUid(mPref.loadDispatchStation());
        body.routeKey.setArrivalStationUid(mPref.loadArriveStation());
        body.routeKey.setDispatchTime(mPref.loadDispatchTime());
        body.setDate(mPref.loadDate());

        String userName = "transit-test";
        String password = "apsHFrD8";
        String base = userName + ":" + password;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

        return mApiService.createApi().getTicketInfo(authHeader, body).execute();
    }
}




