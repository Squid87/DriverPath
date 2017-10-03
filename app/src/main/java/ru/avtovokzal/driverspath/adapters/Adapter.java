package ru.avtovokzal.driverspath.adapters;


import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.model.Ticket;

public class Adapter extends ExpandableRecyclerViewAdapter<TiketParenHolder, TicketChildHolder> {

	private List<Ticket> mTickets = new ArrayList<>();

	public Adapter(List<? extends ExpandableGroup> groups) {
		super(groups);
		mTickets = (List<Ticket>) groups;
	}

	@Override
	public TiketParenHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
		View mInflate1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
		return new TiketParenHolder(mInflate1);
	}

	@Override
	public TicketChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
		View mInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_info, parent, false);
		return new TicketChildHolder(mInflate2);
	}

	@Override
	public void onBindChildViewHolder(TicketChildHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
		Ticket ticket = (Ticket) group.getItems().get(childIndex);
		holder.bind(ticket);
	}

	@Override
	public void onBindGroupViewHolder(TiketParenHolder holder, int flatPosition, ExpandableGroup group) {
		holder.bind(mTickets.get(flatPosition));
	}

}
