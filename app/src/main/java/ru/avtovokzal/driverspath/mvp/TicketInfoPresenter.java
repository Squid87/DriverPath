package ru.avtovokzal.driverspath.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.common.eventbus.Subscribe;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import retrofit2.Response;
import retrofit2.http.Body;
import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.model.RegistrationResponse;
import ru.avtovokzal.driverspath.model.Ticket;
import ru.avtovokzal.driverspath.model.TicketInfo;
import ru.avtovokzal.driverspath.mvp.View.TicketInformationView;
import ru.avtovokzal.driverspath.network.RegistrationBody;
import ru.avtovokzal.driverspath.network.TicketApiInterface;
import ru.avtovokzal.driverspath.network.TicketApiService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class TicketInfoPresenter extends MvpPresenter<TicketInformationView> {

    public TicketApiService mTicketApiService = TicketApiService.getsInstance(Application.getInstance());
    public TicketApiInterface mTicketApiInterface;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        rx.Observable.fromCallable(this::requestTicketInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<RegistrationResponse>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<RegistrationResponse> response) {
                        RegistrationResponse registrationResponse = response.body();
                        List<TicketInfo> mTicketInfos = registrationResponse.getTicketInfos();
                        getViewState().showTicketInfo(mTicketInfos);
                    }
                });
    }

    private Response<RegistrationResponse> requestTicketInfo() throws IOException {
        RegistrationBody body = new RegistrationBody();
        body.arrivalStationUid = "25CBF1CE4E224C0A85C4CCEAD3E4C537";
        body.dispatchStationUid = "E19A767A4C4C43F3855E10DA31CD3749";
        body.dispatchTime = "11:30:00";
        return mTicketApiService.createApi().getTicketInfo(body).execute();
    }
}

//        RegistrationBody body = new RegistrationBody();
//        body.arrivalStationUid = "25CBF1CE4E224C0A85C4CCEAD3E4C537";
//        body.dispatchStationUid = "E19A767A4C4C43F3855E10DA31CD3749";
//        body.dispatchTime = "11:30:00";
//        rx.Observable.fromCallable(mTicketApiInterface.getTicketInfo(body))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Response<RegistrationResponse>>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Response<RegistrationResponse> response) {
//
//                    }
//
//                });



