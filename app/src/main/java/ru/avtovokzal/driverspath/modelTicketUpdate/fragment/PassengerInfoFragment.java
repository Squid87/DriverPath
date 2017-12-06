package ru.avtovokzal.driverspath.modelTicketUpdate.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.StationTicket;
import ru.avtovokzal.driverspath.modelStation.fragment.StationsFragment;
import ru.avtovokzal.driverspath.modelTicketUpdate.mvp.PassengerInfoPresenter;
import ru.avtovokzal.driverspath.modelTicketUpdate.mvp.PassengerInfoView;


@SuppressLint("ValidFragment")
public class PassengerInfoFragment extends MvpAppCompatFragment implements PassengerInfoView {
	private StationsFragment mStationsFragment;
	private FragmentManager mFragmentManager;

	@InjectPresenter
    PassengerInfoPresenter mPassengerInfoPresenter;

	private StationTicket mStationTicket;

	@BindView(R.id.passenger_second_name)
	TextView mPassengerSecondName;

	@BindView(R.id.passenger_first_name)
	TextView mPassengerFirstName;

	@BindView(R.id.passenger_middle_name)
	TextView mPassengerMiddleName;

	@BindView(R.id.passenger_citizen)
	TextView mPassengerCitizen;

	@BindView(R.id.passenger_birthday)
	TextView mPassengerBirthday;

	@BindView(R.id.document)
	TextView mDocument;

	@BindView(R.id.document_number)
	TextView mDocumentNumber;

	@BindView(R.id.document_series)
	TextView mDocumentSeries;

	@BindView(R.id.passenger_gender)
	TextView mPassengerGender;

	@BindView(R.id.ticket_price)
	TextView mTicketPrice;

	@BindView(R.id.ticket_attendance)
	Button mAttendance;

	@BindView(R.id.ticket_no_attendance)
	Button mNoAttendance;

	@BindView(R.id.isGone)
	CheckBox mCheckBoxIsGone;

	@SuppressLint("ValidFragment")
	public PassengerInfoFragment(StationTicket stationTicket) {
		mStationTicket = stationTicket;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_passenger_info, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);
		showView(mStationTicket);

		mAttendance.setOnClickListener(v -> {
			mStationsFragment = new StationsFragment();
			mFragmentManager = getFragmentManager();
			mPassengerInfoPresenter.sendOnServerIsGone(true, mStationTicket.getTicketId());
			mFragmentManager.beginTransaction().
					replace(R.id.activity_main_conteiner, new StationsFragment())
					.addToBackStack(null)
					.commit();
		});


		mNoAttendance.setOnClickListener(v -> {
			mStationsFragment = new StationsFragment();
			mFragmentManager = getFragmentManager();
			mPassengerInfoPresenter.sendOnServerIsGone(false, mStationTicket.getTicketId());
			mFragmentManager.beginTransaction().
					replace(R.id.activity_main_conteiner, new StationsFragment())
					.addToBackStack(null)
					.commit();
		});
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@SuppressLint("SetTextI18n")
	private void showView(StationTicket tickets) {

		if (tickets.getPassenger() != null && tickets.getPassenger().getLastName() != null) {
			mPassengerSecondName.setText(tickets.getPassenger().getLastName());
		} else {
			mPassengerSecondName.setText("");
		}
		if (tickets.getPassenger() != null && tickets.getPassenger().getFirstName() != null) {
			mPassengerFirstName.setText(tickets.getPassenger().getFirstName());
		} else {
			mPassengerFirstName.setText("");
		}
		if (tickets.getPassenger() != null && tickets.getPassenger().getMiddleName() != null) {
			mPassengerMiddleName.setText(tickets.getPassenger().getMiddleName());
		} else {
			mPassengerMiddleName.setText("");
		}

		if (tickets.getPassenger() != null && tickets.getPassenger().getCitizenShip() != null) {
			mPassengerCitizen.setText(tickets.getPassenger().getCitizenShip());
		} else {
			mPassengerCitizen.setText("");
		}

		if (tickets.getPassenger() != null && tickets.getPassenger().getBirthday() != null) {
			mPassengerBirthday.setText(tickets.getPassenger().getBirthday());
		} else {
			mPassengerBirthday.setText("");
		}

		if (tickets.getPassenger() != null && tickets.getPassenger().getDocNum() != null) {
			mDocument.setText(tickets.getPassenger().getDocNum());
		} else {
			mDocument.setText("");
		}
		if (tickets.getPassenger() != null && tickets.getPassenger().getDocSeries() != null) {
			mDocumentSeries.setText(tickets.getPassenger().getDocSeries());
		} else {
			mDocumentSeries.setText("");
		}

		if (tickets.getPassenger() != null && tickets.getPassenger().getDocTypeId() != null) {
			mDocumentNumber.setText(tickets.getPassenger().getDocTypeId());
		} else {
			mDocumentNumber.setText("");
		}

		if (tickets.getPassenger() != null && tickets.getPassenger().getGender() != null) {
			mPassengerGender.setText(tickets.getPassenger().getGender());
		} else {
			mPassengerGender.setText("");
		}

		mTicketPrice.setText(tickets.getPrice() + " " + "руб.");


		if (tickets.direction == "IN") {
			mAttendance.setVisibility(View.VISIBLE);
			mNoAttendance.setVisibility(View.VISIBLE);
		}
		
		if (tickets.isGone()) {
			mCheckBoxIsGone.setChecked(true);
			mCheckBoxIsGone.setText("Явился");
		} else {
			mCheckBoxIsGone.setChecked(true);
			mCheckBoxIsGone.setText("Не явился");
		}
	}

	@Override
	public void showToast() {
		Toast toast = Toast.makeText(Application.getInstance(),
				"Данные данные отправлены!", Toast.LENGTH_LONG);
		toast.show();
		toast.setGravity(Gravity.CENTER, 0, 0);
	}
}
