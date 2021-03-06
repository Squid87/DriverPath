package ru.avtovokzal.driverspath.stations.mvp;


import android.util.Base64;
import android.view.Gravity;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Response;
import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.Pref.Pref;
import ru.avtovokzal.driverspath.database.DatabaseHelper;
import ru.avtovokzal.driverspath.database.DatabaseService;
import ru.avtovokzal.driverspath.stations.model.In;
import ru.avtovokzal.driverspath.stations.model.Out;
import ru.avtovokzal.driverspath.stations.adapters.StationCollector;
import ru.avtovokzal.driverspath.stations.model.StationResponseBody;
import ru.avtovokzal.driverspath.stations.model.StationTicket;
import ru.avtovokzal.driverspath.stations.model.Stops;
import ru.avtovokzal.driverspath.network.RegistrationBody;
import ru.avtovokzal.driverspath.network.ApiService;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class StationInfoPresenter extends MvpPresenter<StationInformationView> {

	private String BASE_URL = "http://webapp.avtovokzal.ru";
	public ApiService mApiService = ApiService.getsInstance(Application.getInstance(), BASE_URL);
	private DatabaseService mDatabaseService = new DatabaseService(Application.getInstance());
	private DatabaseHelper mDatabaseHelper = new DatabaseHelper(Application.getInstance());
	private java.util.Date mDate = new java.util.Date();
	private Pref mPref = new Pref();

	public void startShowStation() {
		super.onFirstViewAttach();
		rx.Observable.fromCallable(this::requestStationInfo)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				//.repeatWhen(completed -> completed.delay(10, TimeUnit.MINUTES))
				.subscribe(new Subscriber<Response<StationResponseBody>>() {
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
							getViewState().showStations(createStationsCollectors(mDatabaseService.loadStops()));
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

					@Override
					public void onNext(Response<StationResponseBody> response) {
						getViewState().showProgressBar();
						StationResponseBody stationResponse = response.body();
						try {
							if (mPref.loadDBKey() == 2) {
								long m = mDate.getTime();
								long s = mPref.loadTime();
								if (m - s < 300000) {
									getViewState().showStations(createStationsCollectors(mDatabaseService.loadStops()));
								} else {
									mDatabaseService.deleteDatabaseStations();
									getViewState().showStations(createStationsCollectors(stationResponse.getStationResponse().getStops()));
									mDatabaseService.saveStops(stationResponse.getStationResponse().getStops());
								}
							} else {
								mPref.saveDBKey(2);
								getViewState().showStations(createStationsCollectors(stationResponse.getStationResponse().getStops()));
								mDatabaseService.saveStops(stationResponse.getStationResponse().getStops());
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				});
	}

	private Response<StationResponseBody> requestStationInfo() throws IOException {

		RegistrationBody body = new RegistrationBody();
		body.routeKey.setDispatchStationUid(mPref.loadDispatchStation());
		body.routeKey.setArrivalStationUid(mPref.loadArriveStation());
		body.routeKey.setDispatchTime(mPref.loadDispatchTime());
		body.setDate(mPref.loadDate());

		String userName = "transit-test";
		String password = "apsHFrD8";
		String base = userName + ":" + password;
		String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
		return mApiService.createApi().getStationInfo(authHeader, body).execute();
	}

	public List<StationCollector> createStationsCollectors(Collection<Stops> station) {
		List<StationCollector> mStationCollectors = new ArrayList<>();
		for (Stops stop : station) {

			List<StationTicket> stationTickets = new ArrayList<>();

			Collection<In> in = stop.getIn();
			Collection<Out> out = stop.getOut();

			if (in != null) {
				for (In item : in) {
					stationTickets.add(createTicketIn(item));
				}
			}
			if (out != null) {
				for (Out item : out) {
					stationTickets.add(createTicketOut(item));
				}
			}
			StationCollector stationCollector = new StationCollector(stop, new ArrayList<>(stationTickets));
			mStationCollectors.add(stationCollector);
		}
		return mStationCollectors;
	}

	public StationTicket createTicketOut(Out item) {
		StationTicket stationTicket = new StationTicket();
		stationTicket.mSeatNum = item.mSeatNum;
		stationTicket.setPassenger(item.mPassenger);
		stationTicket.setIsGone(item.misGone);
		stationTicket.mDispatchStationName = item.mDispatchStationName;
		stationTicket.mArrivalStationName = item.mArrivalStationName;
		stationTicket.setTicketId(item.mTicketId);
		stationTicket.setPrice(item.mPrice);
		stationTicket.direction = "OUT";
		return stationTicket;
	}


	public StationTicket createTicketIn(In item) {
		StationTicket stationTicket = new StationTicket();
		stationTicket.mSeatNum = item.mSeatNum;
		stationTicket.setPassenger(item.mPassenger);
		stationTicket.setPrice(item.mPrice);
		stationTicket.setIsGone(item.misGone);
		stationTicket.mDispatchStationName = item.mDispatchStationName;
		stationTicket.mArrivalStationName = item.mArrivalStationName;
		stationTicket.setTicketId(item.mTicketId);
		stationTicket.direction = "IN";
		return stationTicket;
	}
}
