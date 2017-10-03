package ru.avtovokzal.driverspath.adapters;


import android.net.sip.SipSession;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;

import java.util.ArrayList;
import java.util.List;

import ru.avtovokzal.driverspath.Application;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.model.Ticket;

public class RecyclerViewAdapterTicketInfo extends RecyclerView.Adapter<RecyclerViewTicketInfoHolder> {

    private List<Ticket> mTickets = new ArrayList<>();

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

    public void setTiketInfo(List<Ticket> tickets) {
        mTickets.addAll(tickets);
        notifyDataSetChanged();
    }
}
