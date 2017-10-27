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

    @BindView(R.id.out)
    TextView mMesto;


    @BindView(R.id.in)
    TextView mMestoIn;

    public StationChildHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Stops stops) {

        if (stops.getOut() != null) {
            mMesto.setText("Выходит: " + String.valueOf(stops.getOut().size()) + " человек");
        } else {
            mMesto.setText("Выходит: 0 человек");
        }
        if (stops.getIn() != null) {
            mMestoIn.setText("Входит: " + String.valueOf(stops.getIn().size()) + " человек");
        } else {
            mMestoIn.setText("Входит: 0 человек");
        }

    }
}