package ru.avtovokzal.driverspath.modelStation.mvp;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


import java.util.List;

import ru.avtovokzal.driverspath.modelStation.StationCollector;

@StateStrategyType(SkipStrategy.class)
public interface StationInformationView extends MvpView {

    void showStations(List<StationCollector> stationCollector);

    void showProgressBar();

    void hideProgressBar();
}
