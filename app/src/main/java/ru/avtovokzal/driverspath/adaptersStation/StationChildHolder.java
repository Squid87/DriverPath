package ru.avtovokzal.driverspath.adaptersStation;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.Ticket;
import ru.avtovokzal.driverspath.modelStation.Stops;

class StationChildHolder extends ChildViewHolder {

//    @BindView(R.id.out)
//    TextView mMesto;

//    @BindView(R.id.in)
//    TextView mMestoIn;

    @BindView(R.id.ticket_seat)
    TextView mSeatNumber;

    @BindView(R.id.ticket_dispatch)
    TextView mDispatch;

    @BindView(R.id.ticket_arrive)
    TextView mArrive;


    public StationChildHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    //для item_station_parent_2
//    public void bind(Stops stops) {
//
//        if (stops.getOut() != null) {
//            mMesto.setText("Выходит: " + String.valueOf(stops.getOut().size()) + " человек");
//        } else {
//            mMesto.setText("Выходит: 0 человек");
//        }
//        if (stops.getIn() != null) {
//            mMestoIn.setText("Входит: " + String.valueOf(stops.getIn().size()) + " человек");
//        } else {
//            mMestoIn.setText("Входит: 0 человек");
//        }
//    }

    public void bind2(Stops stops) {
       List<Ticket> mIn = new ArrayList<>(stops.getIn());
       for(int i=0;i<mIn.size();i++){
           bindIn(mIn.get(i));
       }

    }

    private void bindIn(Ticket in) {
        mSeatNumber.setText(String.valueOf(in.getSeatnum()));
    }

    public void bind(Ticket ticket) {
        this.mSeatNumber.setText(String.valueOf(ticket.mSeatnum));
        this.mArrive.setText(ticket.mArrivalstationname);
        this.mDispatch.setText(ticket.mDispatchstationname);
    }
}