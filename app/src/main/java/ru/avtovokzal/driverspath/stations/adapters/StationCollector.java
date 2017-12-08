package ru.avtovokzal.driverspath.stations.adapters;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import ru.avtovokzal.driverspath.stations.model.Stops;


public class StationCollector extends ExpandableGroup {

    public Stops stop;

    public StationCollector(Stops stop, List items) {
        super(stop.getName(), items);
        this.stop = stop;
    }

}
