package ru.avtovokzal.driverspath.modelStation;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;


public class StationCollector extends ExpandableGroup {

    public Stops stop;

    public StationCollector(Stops stop, List items) {
        super(stop.getName(), items);
        this.stop = stop;
    }

}
