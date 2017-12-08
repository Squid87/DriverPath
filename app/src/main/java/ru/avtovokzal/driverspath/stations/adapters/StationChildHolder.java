package ru.avtovokzal.driverspath.stations.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.stations.model.StationTicket;

class StationChildHolder extends ChildViewHolder {

	@BindView(R.id.item_ticket_parent_mesto)
	TextView mMesto;

	@BindView(R.id.item_ticket_seat)
	TextView mSeatNumber;

	@BindView(R.id.item_ticket_dispatch)
	TextView mDispatch;

	@BindView(R.id.item_ticket_arrive)
	TextView mArrive;

	@BindView(R.id.item_ticket_arrow)
	ImageView mImageView;


	public StationChildHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void bind(StationTicket stationTicket) {
		if ("IN".equals(stationTicket.direction)) {
			mMesto.setText("↓ Место");
			mSeatNumber.setText(String.valueOf(stationTicket.mSeatNum));
			mArrive.setText(stationTicket.mArrivalStationName);
			mDispatch.setText(stationTicket.mDispatchStationName);
			mImageView.setVisibility(View.GONE);
		}
		if ("OUT".equals(stationTicket.direction)) {
			mMesto.setText("↑ Место");
			mSeatNumber.setText(String.valueOf(stationTicket.mSeatNum));
			mArrive.setText(stationTicket.mArrivalStationName);
			mDispatch.setText(stationTicket.mDispatchStationName);
			mImageView.setVisibility(View.GONE);
		}

	}
}