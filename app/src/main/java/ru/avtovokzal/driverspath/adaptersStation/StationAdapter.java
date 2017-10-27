package ru.avtovokzal.driverspath.adaptersStation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.In;
import ru.avtovokzal.driverspath.modelStation.Out;
import ru.avtovokzal.driverspath.modelStation.Stops;
import ru.avtovokzal.driverspath.modelTickets.Ticket;


public class StationAdapter extends ExpandableRecyclerViewAdapter<StationParenHolder, StationChildHolder> {

    public StationAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public StationParenHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View mInflate1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station_parent_2, parent, false);
        return new StationParenHolder(mInflate1);
    }

    @Override
    public StationChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View mInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station_child_2, parent, false);
        return new StationChildHolder(mInflate2);
    }

    @Override
    public void onBindChildViewHolder(StationChildHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Stops stops = (Stops) group.getItems().get(childIndex);
        holder.bind((Stops) group.getItems().get(childIndex));
        holder.itemView.setOnClickListener(v -> {

        });
    }

    @Override
    public void onBindGroupViewHolder(StationParenHolder holder, int flatPosition, ExpandableGroup group) {
        holder.bind((Stops) group.getItems().get(0));
    }
}
