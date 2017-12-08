package ru.avtovokzal.driverspath.tickets.mvp;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.avtovokzal.driverspath.tickets.model.Body;

@StateStrategyType(SkipStrategy.class)
public interface TicketInformationView extends MvpView {

    void showTicketInfo(Body mBody);
    void  showProgressBar();
    void  hideProgressBar();

}
