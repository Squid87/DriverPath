package ru.avtovokzal.driverspath.mvp;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.j256.ormlite.support.ConnectionSource;

import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.MainActivity;
import ru.avtovokzal.driverspath.database.DatabaseHelper;
import ru.avtovokzal.driverspath.database.DatabaseService;
import ru.avtovokzal.driverspath.mvp.View.MainView;
import ru.avtovokzal.driverspath.mvp.View.TicketInformationView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

	DatabaseHelper mDatabaseHelper = new DatabaseHelper(Application.getInstance());

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getViewState().start();
	}


	//		rx.Observable.fromCallable(this::isConnect)
	//				.subscribeOn(Schedulers.io())
	//				.observeOn(AndroidSchedulers.mainThread())
	//				.subscribe(new Subscriber<Boolean>() {
	//					@Override
	//					public void onCompleted() {
	//
	//					}
	//
	//					@Override
	//					public void onError(Throwable e) {
	//
	//					}
	//
	//					@Override
	//					public void onNext(Boolean isconnect) {
	//						try {
	//							if (!isconnect && mDatabaseHelper.getBodyDao().idExists(1)) {
	//								Toast toast = Toast.makeText(Application.getInstance(),
	//										"Нет интернета, данные из Базы Данных!", Toast.LENGTH_LONG);
	//								toast.show();
	//								toast.setGravity(Gravity.CENTER, 0, 0);
	//								getViewState().start();							}
	//							if(!isconnect && !mDatabaseHelper.getBodyDao().idExists(1)) {
	//								Toast toast = Toast.makeText(Application.getInstance(),
	//										"Нет интернета, нет Базы Данных!", Toast.LENGTH_LONG);
	//								toast.show();
	//								toast.setGravity(Gravity.CENTER, 0, 0);
	//							}
	//								//вызов активити без интернета!!!!
	//							 else {
	//								getViewState().start();
	//							}
	//						} catch (SQLException e) {
	//							e.printStackTrace();
	//						}
	//					}
	//
	//				});
	//	}
	//
	//
	//	private boolean isConnect() {
	//		ConnectivityManager cm = (ConnectivityManager) Application.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
	//
	//		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
	//		// проверка подключения
	//		if (activeNetwork != null && activeNetwork.isConnected()) {
	//			try {
	//				// тест доступности внешнего ресурса
	//				URL url = new URL("http://www.google.com/");
	//				HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
	//				urlc.setRequestProperty("User-Agent", "test");
	//				urlc.setRequestProperty("Connection", "close");
	//				urlc.setConnectTimeout(3); // Timeout в секундах
	//				urlc.connect();
	//				// статус ресурса OK
	//				if (urlc.getResponseCode() == 200) {
	//					return true;
	//				}
	//				// иначе проверка провалилась
	//				return false;
	//
	//			} catch (IOException e) {
	//				Log.d("my_tag", "Ошибка проверки подключения к интернету", e);
	//				return false;
	//			}
	//		}
	//
	//		return false;
	//	}
}
