package ru.avtovokzal.driverspath.modelTickets.adaptersTickets;


import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelTickets.Ticket;

public class TicketAdapter extends ExpandableRecyclerViewAdapter<TiсketParenHolder, TicketChildHolder> {



    public TicketAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public TiсketParenHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View mInflate1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_parent, parent, false);
        return new TiсketParenHolder(mInflate1);
    }

    @Override
    public TicketChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View mInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_child, parent, false);
        return new TicketChildHolder(mInflate2);
    }

    @Override
    public void onBindChildViewHolder(TicketChildHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Ticket ticket = (Ticket) group.getItems().get(childIndex);
        holder.bind((Ticket) group.getItems().get(childIndex));
}

    @Override
    public void onBindGroupViewHolder(TiсketParenHolder holder, int flatPosition, ExpandableGroup group) {
        holder.bind((Ticket) group.getItems().get(0));
    }

}
