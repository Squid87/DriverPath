package ru.avtovokzal.driverspath.model;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class TicketCollector extends ExpandableGroup {

    public TicketCollector(String title, List items) {
        super(title, items);
    }
}
