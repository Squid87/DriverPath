package ru.avtovokzal.driverspath.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.model.TicketInfo;


public class RecyclerViewTicketInfoHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.seat_number)
    TextView mSeatNumber;

    @BindView(R.id.dispatch_station)
    TextView mDispatchStation;

    @BindView(R.id.arrival_station)
    TextView mArrivalStation;

    @BindView(R.id.item_passenger_second_name)
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


    @BindView(R.id.driver_dispatch_station)
    TextView mDriverDispetchStation;

    @BindView(R.id.driver_arrival_station)
    TextView mDriverArrivalStation;

    @BindView(R.id.driver_time_out)
    TextView mDriverTimeOut;

    @BindView(R.id.free_seats)
    TextView mFreeSeats;

    @BindView(R.id.max_seats)
    TextView mMaxSeats;


    public RecyclerViewTicketInfoHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(TicketInfo ticketInfo) {

        mFreeSeats.setText(ticketInfo.getBody().getFreeseats());
        mMaxSeats.setText(ticketInfo.getBody().getMaxseats());

        mSeatNumber.setText(ticketInfo.getBody().getTicket().get(0).getSeatnum());
        mDispatchStation.setText(ticketInfo.getBody().getTicket().get(0).getDispatchStationName());
        mArrivalStation.setText(ticketInfo.getBody().getTicket().get(0).getArrivalStationName());
        mPassengerSecondName.setText(ticketInfo.getBody().getTicket().get(0).getPassenger().getLastName());
        mPassengerFirstName.setText(ticketInfo.getBody().getTicket().get(0).getPassenger().getFirstName());
        mPassengerMiddleName.setText(ticketInfo.getBody().getTicket().get(0).getPassenger().getMiddleName());
        mPassengerCitizen.setText(ticketInfo.getBody().getTicket().get(0).getPassenger().getCitizenship());
        //mPassengerBirthday.setText(ticketInfo.getBody().getTicket().get(i).getPassenger().getBirthday());
        mDocument.setText(ticketInfo.getBody().getTicket().get(0).getPassenger().getDocTypeId());
        mDocumentNumber.setText(ticketInfo.getBody().getTicket().get(0).getPassenger().getDocNum());
        mDocumentSeries.setText(ticketInfo.getBody().getTicket().get(0).getPassenger().getDocSeries());
        // mPassengerGender.setText(ticketInfo.getBody().getTicket().get(i).getPassenger().getGender());
        mTicketPrice.setText(ticketInfo.getBody().getTicket().get(0).getPrice());


    }
}
