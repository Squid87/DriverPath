package ru.avtovokzal.driverspath.mvp;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import ru.avtovokzal.driverspath.mvp.View.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public MainPresenter() {
        getViewState().start();
    }
}
