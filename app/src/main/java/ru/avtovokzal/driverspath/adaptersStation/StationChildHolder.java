package ru.avtovokzal.driverspath.adaptersStation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.nfc.cardemulation.CardEmulation;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.In;
import ru.avtovokzal.driverspath.modelStation.Out;
import ru.avtovokzal.driverspath.modelStation.Stops;
import ru.avtovokzal.driverspath.modelTickets.Ticket;

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
       List<In> mIn = new ArrayList<>(stops.getIn());
       for(int i=0;i<mIn.size();i++){
           bindIn(mIn.get(i));
       }

    }

    private void bindIn(In in) {
        mSeatNumber.setText(String.valueOf(in.getSeatnum()));
    }

}