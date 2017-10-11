package ru.avtovokzal.driverspath;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.fragments.TicketInformationFragment;
import ru.avtovokzal.driverspath.model.Body;
import ru.avtovokzal.driverspath.mvp.MainPresenter;
import ru.avtovokzal.driverspath.mvp.View.MainView;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBind();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    private void initBind() {
        ButterKnife.bind(this);
    }


    @Override
    public void start() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteiner, new TicketInformationFragment())
                .commit();
        getSupportFragmentManager().executePendingTransactions();

    }
}
