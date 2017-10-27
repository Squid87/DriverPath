package ru.avtovokzal.driverspath.adaptersTickets;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelTickets.Ticket;

public class TiсketParenHolder extends GroupViewHolder {

    @BindView(R.id.ticket_seat)
    TextView mMesto;

    @BindView(R.id.ticket_dispatch)
    TextView mDespetch;

    @BindView(R.id.ticket_arrive)
    TextView mArrive;

    public TiсketParenHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void bind(Ticket tickets) {
        mMesto.setText(String.valueOf(tickets.getSeatnum()));
        mArrive.setText(tickets.getArrivalStationName());
        mDespetch.setText(tickets.getDispatchStationName());
    }


}
