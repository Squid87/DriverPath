package ru.avtovokzal.driverspath.mvp;

import android.util.Base64;
import android.view.Gravity;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.io.IOException;
import java.sql.SQLException;

import retrofit2.Response;
import ru.avtovokzal.driverspath.Application;
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

    private String BASE_URL = "http://webapp.avtovokzal.ru";
    private DatabaseService mDatabaseService = new DatabaseService(Application.getInstance());
    private DatabaseHelper mDatabaseHelper = new DatabaseHelper(Application.getInstance());

    public ApiService mApiService = ApiService.getsInstance(Application.getInstance(), BASE_URL);


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
                        getViewState().showTicketInfo(registrationResponse.getBody());

                        try {
                            if (!mDatabaseHelper.getBodyDao().isTableExists()) {
                                mDatabaseService.saveTickets(registrationResponse.getBody());
                            } else {
                                mDatabaseService.deleteDatabase();
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
        body.routeKey.dispatchStationUid = "E19A767A4C4C43F3855E10DA31CD3749";
        body.routeKey.arrivalStationUid = "25CBF1CE4E224C0A85C4CCEAD3E4C537";
        body.routeKey.dispatchTime = "11:30:00";
        body.date = "2017-09-10";

        String userName = "transit-test";
        String password = "apsHFrD8";
        String base = userName + ":" + password;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

        return mApiService.createApi().getTicketInfo(authHeader, body).execute();
    }
}




