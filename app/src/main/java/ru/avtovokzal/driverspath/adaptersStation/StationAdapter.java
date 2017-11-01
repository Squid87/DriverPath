package ru.avtovokzal.driverspath.adaptersStation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.Stops;
import ru.avtovokzal.driverspath.modelStation.Ticket;


public class StationAdapter extends ExpandableRecyclerViewAdapter<StationParenHolder, StationChildHolder> {

    public StationAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public StationParenHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View mInflate1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station_parent, parent, false);
        return new StationParenHolder(mInflate1);
    }

    @Override
    public StationChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View mInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket_parent, parent, false);
        return new StationChildHolder(mInflate2);
    }

    @Override
    public void onBindChildViewHolder(StationChildHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        //holder.bind((Stops) group.getItems().get(childIndex));


        //вот тут нужно кинуть по идеи класс IN или Out в bind. и собственно показывать его. Типа holder.bind2(stops.getIn);
        holder.bind((Ticket)group.getItems().get(childIndex));
    }

    @Override
    public void onBindGroupViewHolder(StationParenHolder holder, int flatPosition, ExpandableGroup group) {

        holder.bind((Stops) group.getItems().get(0));
    }
}
