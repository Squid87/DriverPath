package ru.avtovokzal.driverspath.details.mvp;


import android.util.Base64;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.io.IOException;

import retrofit2.Response;
import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.Pref.Pref;
import ru.avtovokzal.driverspath.details.model.TicketUpdateResponse;
import ru.avtovokzal.driverspath.details.model.UpdateTicket;
import ru.avtovokzal.driverspath.network.ApiService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class PassengerInfoPresenter extends MvpPresenter<PassengerInfoView> {

    private String BASE_URL = "http://webapp.avtovokzal.ru";
    public ApiService mApiService = ApiService.getsInstance(Application.getInstance(), BASE_URL);
    private Pref mPref = new Pref();

    private boolean isGone;
    private String ticketId;

    public void sendOnServerIsGone(boolean isGone, String ticketId) {
        this.isGone = isGone;
        this.ticketId = ticketId;

        rx.Observable.fromCallable(this::requestUpdateTicket)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<TicketUpdateResponse>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<TicketUpdateResponse> ticketUpdateResponseResponse) {
                        TicketUpdateResponse mTicketUpdateResponse = ticketUpdateResponseResponse.body();
                        getViewState().showToast();

                    }
                });


    }

    private Response<TicketUpdateResponse> requestUpdateTicket() throws IOException {
        UpdateTicket mUpdateTicket = new UpdateTicket();
        mUpdateTicket.routeKey.setDispatchStationUid(mPref.loadDispatchStation());
        mUpdateTicket.routeKey.setArrivalStationUid(mPref.loadArriveStation());
        mUpdateTicket.routeKey.setDispatchTime(mPref.loadDispatchTime());
        mUpdateTicket.setDate(mPref.loadDate());
        mUpdateTicket.setTicketId(ticketId);
        mUpdateTicket.setGone(isGone);

        String userName = "transit-test";
        String password = "apsHFrD8";
        String base = userName + ":" + password;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
        return mApiService.createApi().setUpdateTicket(authHeader, mUpdateTicket).execute();
    }

}
