package ru.avtovokzal.driverspath.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.model.Body;
import ru.avtovokzal.driverspath.model.Ticket;
import ru.avtovokzal.driverspath.model.TicketInfo;

public class RecyclerViewAdapterTicketInfo extends RecyclerView.Adapter<RecyclerViewTicketInfoHolder> {

    private List<TicketInfo> mTickets = new ArrayList<>();


    @Override
    public RecyclerViewTicketInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_info, parent, false);
        return new RecyclerViewTicketInfoHolder(mInflate);
    }

    @Override
    public void onBindViewHolder(RecyclerViewTicketInfoHolder holder, int position) {
        holder.bind(mTickets.get(position));

    }

    @Override
    public int getItemCount() {
        return mTickets.size();
    }

    public void setTiketInfo(List<TicketInfo> tickets) {
        mTickets.addAll(tickets);
        notifyDataSetChanged();
    }
}
