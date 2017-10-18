package ru.avtovokzal.driverspath;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.fragments.TicketInformationFragment;

public class MainActivity extends MvpAppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBind();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteiner, new TicketInformationFragment())
                .commit();
        getSupportFragmentManager().executePendingTransactions();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    private void initBind() {
        ButterKnife.bind(this);
    }

}
