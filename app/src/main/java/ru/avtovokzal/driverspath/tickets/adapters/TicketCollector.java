package ru.avtovokzal.driverspath.tickets.adapters;


import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class TicketCollector extends ExpandableGroup {

    public TicketCollector(String title, List items) {
        super(title, items);
    }
}
