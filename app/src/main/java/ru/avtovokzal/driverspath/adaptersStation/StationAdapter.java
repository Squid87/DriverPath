package ru.avtovokzal.driverspath.adaptersStation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.modelStation.StationCollector;
import ru.avtovokzal.driverspath.modelStation.StationTicket;


public class StationAdapter extends ExpandableRecyclerViewAdapter<StationParenHolder, StationChildHolder> {

    private Listener listener;

    public static interface Listener {
        public void onClick(StationTicket ticket);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

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
        StationTicket stationTicket = (StationTicket) group.getItems().get(childIndex);
        holder.bind(stationTicket);
        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onClick(stationTicket);
            }
        });
    }

    @Override
    public void onBindGroupViewHolder(StationParenHolder holder, int flatPosition, ExpandableGroup group) {
        StationCollector stationCollector = (StationCollector) group;
        holder.bind(stationCollector.stop);
    }
}
