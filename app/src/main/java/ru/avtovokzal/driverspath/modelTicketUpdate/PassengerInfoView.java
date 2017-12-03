package ru.avtovokzal.driverspath.modelTicketUpdate;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface PassengerInfoView extends MvpView {
    void showToast();
}
