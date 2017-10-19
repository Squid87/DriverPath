package ru.avtovokzal.driverspath;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.fragments.TicketInformationFragment;
import ru.avtovokzal.driverspath.model.Body;
import ru.avtovokzal.driverspath.mvp.MainPresenter;
import ru.avtovokzal.driverspath.mvp.View.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {

	@InjectPresenter
	MainPresenter mMainPresenter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initBind();
	}

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}


	private void initBind() {
		ButterKnife.bind(this);
	}

	@Override
	public void start() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.activity_main_conteiner, new TicketInformationFragment())
				.commit();
		getSupportFragmentManager().executePendingTransactions();
	}

}
