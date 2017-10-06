package ru.avtovokzal.driverspath.adapters;


import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.model.Body;
import ru.avtovokzal.driverspath.model.Ticket;

public class TicketAdapter extends ExpandableRecyclerViewAdapter<TiketParenHolder, TicketChildHolder> {

    public TicketAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public TiketParenHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View mInflate1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_parent, parent, false);
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
        holder.bind((Ticket) group.getItems().get(childIndex));
    }

    @Override
    public void onBindGroupViewHolder(TiketParenHolder holder, int flatPosition, ExpandableGroup group) {
        holder.bind((Ticket) group.getItems().get(flatPosition));
    }

}
