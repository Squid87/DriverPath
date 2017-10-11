package ru.avtovokzal.driverspath.adapters;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.model.Ticket;


public class TicketChildHolder extends ChildViewHolder {


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


    public TicketChildHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Ticket ticketInfo) {
        if (ticketInfo.getPassenger().getLastName() != null) {
            mPassengerSecondName.setText(ticketInfo.getPassenger().getLastName());
        } else {
            mPassengerSecondName.setText(R.string.noInformatione);
        }
        if (ticketInfo.getPassenger().getFirstName() != null) {
            mPassengerFirstName.setText(ticketInfo.getPassenger().getFirstName());
        } else {
            mPassengerFirstName.setText(R.string.noInformatione);
        }
        if (ticketInfo.getPassenger().getMiddleName() != null) {
            mPassengerMiddleName.setText(ticketInfo.getPassenger().getMiddleName());
        } else {
            mPassengerMiddleName.setText(R.string.noInformatione);
        }

        if (ticketInfo.getPassenger().getCitizenship() != null) {
            mPassengerCitizen.setText(ticketInfo.getPassenger().getCitizenship());
        } else {
            mPassengerCitizen.setText(R.string.noInformatione);
        }

        if (ticketInfo.getPassenger().getBirthday() != null) {
            mPassengerBirthday.setText(ticketInfo.getPassenger().getBirthday());
        } else {
            mPassengerBirthday.setText(R.string.noInformatione);
        }

        if (ticketInfo.getPassenger().getDocTypeId() != null) {
            mDocument.setText(ticketInfo.getPassenger().getDocTypeId());
        } else {
            mDocument.setText(R.string.noInformatione);
        }
        if (ticketInfo.getPassenger().getDocSeries() != null) {
            mDocumentSeries.setText(ticketInfo.getPassenger().getDocSeries());
        } else {
            mDocumentSeries.setText(R.string.noInformatione);
        }

        if (ticketInfo.getPassenger().getDocNum() != null) {
            mDocumentNumber.setText(ticketInfo.getPassenger().getDocNum());
        } else {
            mDocumentNumber.setText(R.string.noInformatione);
        }

        if (ticketInfo.getPassenger().getGender() != null) {
            mPassengerGender.setText(ticketInfo.getPassenger().getGender());
        } else {
            mPassengerGender.setText(R.string.noInformatione);
        }

        mTicketPrice.setText(ticketInfo.getPrice() + " " + "руб.");

    }
}
