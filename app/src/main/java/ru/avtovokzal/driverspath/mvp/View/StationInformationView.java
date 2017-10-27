package ru.avtovokzal.driverspath.mvp.View;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.Collection;
import java.util.List;

import ru.avtovokzal.driverspath.modelStation.Stops;

@StateStrategyType(SkipStrategy.class)
public interface StationInformationView extends MvpView {

    void showStations(Collection<Stops> station);

    void showProgressBar();

    void hideProgressBar();
}
