package ru.avtovokzal.driverspath;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.mvp.LoginPresenter;
import ru.avtovokzal.driverspath.mvp.View.LoginView;


public class LoginActivity extends MvpAppCompatActivity implements LoginView {
    @InjectPresenter
    LoginPresenter mLoginPresenter;

    private String[] city = {"Барнаул", "Белокуриха", "Бийск"};
    private String mDispatchCity;
    private String mArriveCity;

    @BindView(R.id.spinner_arrive_station)
    Spinner mSpinnerArrive;

    @BindView(R.id.spinner_dispatch_station)
    Spinner mSpinnerDispatch;

    @BindView(R.id.login_button)
    Button mLoginButton;

    @BindView(R.id.login_set_date)
    Button mSetDateButton;

    @BindView(R.id.login_set_time)
    Button mSetTimeButton;

    @BindView(R.id.login_data)
    TextView mDateTextView;

    @BindView(R.id.login_time)
    TextView mTimeTextView;

    Calendar dateAndTime = Calendar.getInstance();

    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sTime = new SimpleDateFormat("HH:mm:ss");
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");

    public String date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //setInitialDateTime();


        //ArrayAdapter<?> adapterDispatch = ArrayAdapter.createFromResource(this, R.array.city, R.layout.spinner_text);
        ArrayAdapter<?> adapterArrive = ArrayAdapter.createFromResource(this, R.array.city, R.layout.spinner_text);

        @SuppressLint("ResourceType")
        ArrayAdapter<?> adapterDispatch = new ArrayAdapter<String>(this, R.layout.spinner_text, R.id.spinner_text1, city);

        mSpinnerDispatch.setAdapter(adapterDispatch);
        mSpinnerArrive.setAdapter(adapterArrive);

        mSetDateButton.setOnClickListener(this::setDate);
        mSetTimeButton.setOnClickListener(this::setTime);

        mLoginButton.setOnClickListener(v -> {
            time = (String) mTimeTextView.getText();
            mDispatchCity = getStationUid((String) mSpinnerDispatch.getSelectedItem());
            mArriveCity = getStationUid((String) mSpinnerArrive.getSelectedItem());
            mLoginPresenter.startPath(mDispatchCity, mArriveCity);
        });
    }

    public String getStationUid(String city) {
        switch (city) {
            case "Белокуриха":
                return "E19A767A4C4C43F3855E10DA31CD3749";
            case "Рубцовск":
                return "25CBF1CE4E224C0A85C4CCEAD3E4C537";
        }
        return "25CBF1CE4E224C0A85C4CCEAD3E4C537";
    }

    private void setInitialDateTime() {
        mDateTextView.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_YEAR | DateUtils.FORMAT_NUMERIC_DATE));
        mTimeTextView.setText(DateUtils.formatDateTime(this, dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME));
    }

    public void setDate(View v) {
        new DatePickerDialog(this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {
        new TimePickerDialog(this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t = (view, hourOfDay, minute) -> {
        dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        dateAndTime.set(Calendar.MINUTE, minute);
        setInitialDateTime();
    };

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) -> {
        dateAndTime.set(Calendar.YEAR, year);
        dateAndTime.set(Calendar.MONTH, monthOfYear);
        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        setInitialDateTime();
    };

    @Override
    public void startTicket() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
