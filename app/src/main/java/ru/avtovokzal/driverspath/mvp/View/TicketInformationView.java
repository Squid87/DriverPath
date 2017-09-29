package ru.avtovokzal.driverspath.mvp.View;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.avtovokzal.driverspath.model.Body;
import ru.avtovokzal.driverspath.model.Ticket;

@StateStrategyType(SkipStrategy.class)
public interface TicketInformationView extends MvpView {

    void showTicketInfo(Body mBody);
    void  showError();
    void  showProgressBar();
    void  hideProgressBar();

}
