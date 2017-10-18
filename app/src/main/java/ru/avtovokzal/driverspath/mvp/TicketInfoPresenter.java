package ru.avtovokzal.driverspath.mvp;

import android.util.Base64;
import android.view.Gravity;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import retrofit2.Response;
import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.database.DatabaseService;
import ru.avtovokzal.driverspath.model.RegistrationResponse;
import ru.avtovokzal.driverspath.model.Ticket;
import ru.avtovokzal.driverspath.mvp.View.TicketInformationView;
import ru.avtovokzal.driverspath.network.RegistrationBody;
import ru.avtovokzal.driverspath.network.TicketApiService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class TicketInfoPresenter extends MvpPresenter<TicketInformationView> {

    public TicketApiService mTicketApiService = TicketApiService.getsInstance(Application.getInstance());
    DatabaseService mDatabaseService = new DatabaseService(Application.getInstance());



    @Override
    protected void onFirstViewAttach() {
        rx.Observable.fromCallable(this::requestTicketInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.repeatWhen(completed -> completed.delay(10, TimeUnit.MINUTES))
                .subscribe(new Subscriber<Response<RegistrationResponse>>() {

                    @Override
                    public void onCompleted() {
                        getViewState().hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().hideProgressBar();
                        Toast toast = Toast.makeText(Application.getInstance(),
                                "Произошла ошибка!", Toast.LENGTH_LONG);
                        toast.show();
                        toast.setGravity(Gravity.CENTER, 0, 0);
                    }

                    @Override
                    public void onNext(Response<RegistrationResponse> response) {
                        getViewState().showProgressBar();
                        RegistrationResponse registrationResponse = response.body();
                        getViewState().showTicketInfo(registrationResponse.getBody());

                        try {
                            mDatabaseService.saveTickets(registrationResponse.getBody());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private Response<RegistrationResponse> requestTicketInfo() throws IOException {

        RegistrationBody body = new RegistrationBody();
        body.routeKey.dispatchStationUid = "E19A767A4C4C43F3855E10DA31CD3749";
        body.routeKey.arrivalStationUid = "25CBF1CE4E224C0A85C4CCEAD3E4C537";
        body.routeKey.dispatchTime = "11:30:00";
        body.date = "2017-09-10";

        String userName = "transit-test";
        String password = "apsHFrD8";
        String base = userName + ":" + password;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

        return mTicketApiService.createApi().getTicketInfo(authHeader, body).execute();
    }
}




