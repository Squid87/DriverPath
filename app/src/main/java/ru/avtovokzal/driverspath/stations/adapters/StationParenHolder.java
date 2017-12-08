package ru.avtovokzal.driverspath.stations.adapters;


import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.stations.model.Stops;

class StationParenHolder extends GroupViewHolder {

	@BindView(R.id.station_dispatch)
	TextView mStationDispatch;

	@BindView(R.id.station_dispatch_time)
	TextView mStationDispatchTime;

	@BindView(R.id.station_in_people)
	TextView mPeopleIn;

	@BindView(R.id.station_out_people)
	TextView mPeopleOut;

	public StationParenHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void bind(Stops stops) {
		mStationDispatch.setText(stops.getName());
		if (stops.getIn() != null) {
			mPeopleIn.setText("↓ " + stops.getIn().size());
		} else {
			mPeopleIn.setText("↓ 0");
		}
		if (stops.getOut() != null) {
			mPeopleOut.setText("↑ " + stops.getOut().size());
		} else {
			mPeopleOut.setText("↑ 0");
		}
	}
}
