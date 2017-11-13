package ru.avtovokzal.driverspath.adaptersStation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.Ticket;

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

	public void bind(Ticket ticket) {
		if (ticket.direction == "IN") {
			mMesto.setText("↑ " + "Место");
			mSeatNumber.setText(String.valueOf(ticket.mSeatnum));
			mArrive.setText(ticket.mArrivalstationname);
			mDispatch.setText(ticket.mDispatchstationname);
			mImageView.setVisibility(View.GONE);
		}
		if (ticket.direction == "OUT") {
			mMesto.setText("↓ " + "Место");
			mSeatNumber.setText(String.valueOf(ticket.mSeatnum));
			mArrive.setText(ticket.mArrivalstationname);
			mDispatch.setText(ticket.mDispatchstationname);
			mImageView.setVisibility(View.GONE);
		}

	}
}