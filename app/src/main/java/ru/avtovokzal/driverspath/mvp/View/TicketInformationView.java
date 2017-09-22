package ru.avtovokzal.driverspath.mvp.View;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.avtovokzal.driverspath.model.TicketInfo;

@StateStrategyType(SkipStrategy.class)
public interface TicketInformationView extends MvpView {

    void showTicketInfo(List<TicketInfo> ticketInfo);
}
