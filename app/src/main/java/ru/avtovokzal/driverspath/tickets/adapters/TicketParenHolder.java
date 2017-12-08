package ru.avtovokzal.driverspath.tickets.adapters;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.tickets.model.Ticket;

public class TicketParenHolder extends GroupViewHolder {

    @BindView(R.id.item_ticket_seat)
    TextView mSeatNumber;

    @BindView(R.id.item_ticket_parent_mesto)
    TextView mMesto;

    @BindView(R.id.item_ticket_dispatch)
    TextView mDispatch;

    @BindView(R.id.item_ticket_arrive)
    TextView mArrive;

    public TicketParenHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void bind(Ticket tickets) {
        mMesto.setText("Место ");
        mSeatNumber.setText(String.valueOf(tickets.getSeatNum()));
        mArrive.setText(tickets.getArrivalStationName());
        mDispatch.setText(tickets.getDispatchStationName());
    }


}
