package ru.avtovokzal.driverspath.adaptersStation;


import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.Stops;

class StationParenHolder extends GroupViewHolder {

    @BindView(R.id.station_dispatch)
    TextView mStationDispatch;

    @BindView(R.id.station_dispatch_time)
    TextView mStationDispatchTime;

    @BindView(R.id.station_in_arrival_time)
    TextView mPeopleIn;

//    @BindView(R.id.station_out_people)
//    TextView mPeopleOut;

    public StationParenHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Stops stops) {
        mStationDispatch.setText(stops.getName());
        if (stops.getDispatchtime() != null) {
            mStationDispatchTime.setText(String.valueOf(stops.getDispatchtime()));
        } else {
            mStationDispatchTime.setText("00:00");
        }
        if (stops.getmArrivaltime() != null) {
            mPeopleIn.setText(String.valueOf(stops.getmArrivaltime()));
        } else {
            mPeopleIn.setText("00:00");
        }


//        if (stops.getOut() != null) {
//            mPeopleOut.setText("↓ " + String.valueOf(stops.getOut().size()));
//        } else {
//            mPeopleOut.setText("↓ " + "0");
//        }
    }

}