package ru.avtovokzal.driverspath;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.fragments.TicketInformationFragment;
import ru.avtovokzal.driverspath.model.Body;

public class MainActivity extends MvpAppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        initBind();
        openTicketInformation();
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void openTicketInformation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main_conteiner, new TicketInformationFragment())
                .commit();
        getSupportFragmentManager().executePendingTransactions();
    }


    private void initBind() {
        ButterKnife.bind(this);
    }
}
