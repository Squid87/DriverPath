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

	@BindView(R.id.item_ticket_parent_mesto)
	TextView mMesto;

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

	public void bind(Ticket ticket) {
		if (ticket.direction == "IN") {
			mMesto.setText("↑ " + "Место");
			mSeatNumber.setText(String.valueOf(ticket.mSeatnum));
			mArrive.setText(ticket.mArrivalstationname);
			mDispatch.setText(ticket.mDispatchstationname);
		}
		if (ticket.direction == "OUT") {
			mMesto.setText("↓ " + "Место");
			mSeatNumber.setText(String.valueOf(ticket.mSeatnum));
			mArrive.setText(ticket.mArrivalstationname);
			mDispatch.setText(ticket.mDispatchstationname);
		}

	}
}