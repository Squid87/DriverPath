package ru.avtovokzal.driverspath.fragments;


import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.StationTicket;


@SuppressLint("ValidFragment")
public class PassengerInfoFragment extends Fragment {

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
    ImageButton mAttendance;

    @BindView(R.id.ticket_no_attendance)
    ImageButton mNoAttendance;

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
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void showView(StationTicket tikets) {

        if (tikets.getPassenger() != null && tikets.getPassenger().getLastname() != null) {
            mPassengerSecondName.setText(tikets.getPassenger().getLastname());
        } else {
            mPassengerSecondName.setText(R.string.noInformatione);
        }
        if (tikets.getPassenger() != null && tikets.getPassenger().getFirstname() != null) {
            mPassengerFirstName.setText(tikets.getPassenger().getFirstname());
        } else {
            mPassengerFirstName.setText(R.string.noInformatione);
        }
        if (tikets.getPassenger() != null && tikets.getPassenger().getMiddlename() != null) {
            mPassengerMiddleName.setText(tikets.getPassenger().getMiddlename());
        } else {
            mPassengerMiddleName.setText(R.string.noInformatione);
        }

        if (tikets.getPassenger() != null && tikets.getPassenger().getCitizenshipiso2() != null) {
            mPassengerCitizen.setText(tikets.getPassenger().getFirstname());
        } else {
            mPassengerCitizen.setText(R.string.noInformatione);
        }

        if (tikets.getPassenger() != null && tikets.getPassenger().getBirthday() != null) {
            mPassengerBirthday.setText(tikets.getPassenger().getBirthday());
        } else {
            mPassengerBirthday.setText(R.string.noInformatione);
        }

        if (tikets.getPassenger() != null && tikets.getPassenger().getDocnum() != null) {
            mDocument.setText(tikets.getPassenger().getFirstname());
        } else {
            mDocument.setText(R.string.noInformatione);
        }
        if (tikets.getPassenger() != null && tikets.getPassenger().getDocseries() != null) {
            mDocumentSeries.setText(tikets.getPassenger().getDocseries());
        } else {
            mDocumentSeries.setText(R.string.noInformatione);
        }

        if (tikets.getPassenger() != null && tikets.getPassenger().getDoctypeid() != null) {
            mDocumentNumber.setText(tikets.getPassenger().getDoctypeid());
        } else {
            mDocumentNumber.setText(R.string.noInformatione);
        }

        if (tikets.getPassenger() != null && tikets.getPassenger().getGender() != null) {
            mPassengerGender.setText(tikets.getPassenger().getGender());
        } else {
            mPassengerGender.setText(R.string.noInformatione);
        }
        if (tikets.direction == "IN") {
            mAttendance.setVisibility(View.VISIBLE);
            mNoAttendance.setVisibility(View.VISIBLE);
        }
    }

}
