package ru.avtovokzal.driverspath;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.fragments.StationsFragment;
import ru.avtovokzal.driverspath.fragments.TicketInformationFragment;
import ru.avtovokzal.driverspath.mvp.MainPresenter;
import ru.avtovokzal.driverspath.mvp.View.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter mMainPresenter;

    @BindView(R.id.menu_navigation_ticket)
    BottomNavigationItemView mBottomNavigationItem;

    @BindView(R.id.bottom_navigation_menu)
    BottomNavigationView mBottomNavigationMenu;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBind();

        mMainPresenter.checkConnect(MainActivity.this);

        //переключение между экранами
        mBottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_navigation_ticket:
                        mMainPresenter.getViewState().startShowTickets();
                        break;
                    case R.id.menu_navigation_stations:
                        mMainPresenter.getViewState().startShowStations();
                        break;
                    case R.id.menu_navigation_about:
                        break;
                }
                return false;
            }
        });

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    private void initBind() {
        ButterKnife.bind(this);
    }

    @Override
    public void startShowTickets() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteiner, new TicketInformationFragment())
                .commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    @Override
    public void startShowStations() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteiner, new StationsFragment())
                .commit();
        getSupportFragmentManager().executePendingTransactions();

    }

    @Override
    public void close() {
        System.exit(0);
    }
}
