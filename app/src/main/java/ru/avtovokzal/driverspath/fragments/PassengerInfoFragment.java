package ru.avtovokzal.driverspath.fragments;


import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.StationTicket;


@SuppressLint("ValidFragment")
public class PassengerInfoFragment extends Fragment {

	private List<StationTicket> mStationTickets = new ArrayList<>();
	private int position;

	@BindView(R.id.passenger_second_name)
	TextView mPassengerSecondName;

	@BindView(R.id.item_passenger_first_name)
	TextView mPassengerFirstName;

	@BindView(R.id.item_passenger_middle_name)
	TextView mPassengerMiddleName;

	@BindView(R.id.item_passenger_citizen)
	TextView mPassengerCitizen;

	@BindView(R.id.item_passenger_birthday)
	TextView mPassengerBirthday;

	@BindView(R.id.item_document)
	TextView mDocument;

	@BindView(R.id.item_document_number)
	TextView mDocumentNumber;

	@BindView(R.id.item_document_series)
	TextView mDocumentSeries;

	@BindView(R.id.item_passenger_gender)
	TextView mPassengerGender;

	@BindView(R.id.item_ticket_price)
	TextView mTicketPrice;

	@BindView(R.id.ticket_attendance)
	Button mAttendance;

	@BindView(R.id.ticket_no_attendance)
	Button mNoAttendance;

	@SuppressLint("ValidFragment")
	public PassengerInfoFragment(int position, List<StationTicket> stationTicket) {
		mStationTickets.addAll(stationTicket);
		this.position = position;
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
		showView(mStationTickets);
	}


	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	private void showView(List<StationTicket> tikets) {


		if (tikets.get(position).getPassenger().getLastname() != null) {
			mPassengerSecondName.setText(tikets.get(position).getPassenger().getLastname());
		} else {
			mPassengerSecondName.setText(R.string.noInformatione);
		}
		if (tikets.get(position).getPassenger().getFirstname() != null) {
			mPassengerFirstName.setText(tikets.get(position).getPassenger().getFirstname());
		} else {
			mPassengerFirstName.setText(R.string.noInformatione);
		}
		if (tikets.get(position).getPassenger().getMiddlename() != null) {
			mPassengerMiddleName.setText(tikets.get(position).getPassenger().getMiddlename());
		} else {
			mPassengerMiddleName.setText(R.string.noInformatione);
		}

		if (tikets.get(position).getPassenger().getCitizenshipiso2() != null) {
			mPassengerCitizen.setText(tikets.get(position).getPassenger().getFirstname());
		} else {
			mPassengerCitizen.setText(R.string.noInformatione);
		}

		if (tikets.get(position).getPassenger().getBirthday() != null) {
			mPassengerBirthday.setText(tikets.get(position).getPassenger().getBirthday());
		} else {
			mPassengerBirthday.setText(R.string.noInformatione);
		}

		if (tikets.get(position).getPassenger().getDocnum() != null) {
			mDocument.setText(tikets.get(position).getPassenger().getFirstname());
		} else {
			mDocument.setText(R.string.noInformatione);
		}
		if (tikets.get(position).getPassenger().getDocseries() != null) {
			mDocumentSeries.setText(tikets.get(position).getPassenger().getDocseries());
		} else {
			mDocumentSeries.setText(R.string.noInformatione);
		}

		if (tikets.get(position).getPassenger().getDoctypeid() != null) {
			mDocumentNumber.setText(tikets.get(position).getPassenger().getDoctypeid());
		} else {
			mDocumentNumber.setText(R.string.noInformatione);
		}

		if (tikets.get(position).getPassenger().getGender() != null) {
			mPassengerGender.setText(tikets.get(position).getPassenger().getGender());
		} else {
			mPassengerGender.setText(R.string.noInformatione);
		}
		mAttendance.setVisibility(View.VISIBLE);
		mNoAttendance.setVisibility(View.VISIBLE);
	}

}
