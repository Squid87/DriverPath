package ru.avtovokzal.driverspath.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.adapters.RecyclerViewAdapterTicketInfo;
import ru.avtovokzal.driverspath.model.Body;
import ru.avtovokzal.driverspath.mvp.TicketInfoPresenter;
import ru.avtovokzal.driverspath.mvp.View.TicketInformationView;

public class TicketInformationFragment extends MvpAppCompatFragment implements TicketInformationView {

    @InjectPresenter
    TicketInfoPresenter mTicketInfoPresenter;
    RecyclerViewAdapterTicketInfo mRecyclerViewAdapterTicketInfo;

    @BindView(R.id.fragment_ticket_info_recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.free_seats)
    TextView mFreeSeats;

    @BindView(R.id.max_seats)
    TextView mMaxSeats;

    @BindView(R.id.driver_dispatch_station)
    TextView mDispatchStation;

    @BindView(R.id.driver_arrival_station)
    TextView mArrivalStation;

    @BindView(R.id.driver_time_out)
    TextView mDriverTimeOut;

    @BindView(R.id.driver_inn)
    TextView mDriverInn;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ticket_information, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerViewAdapterTicketInfo = new RecyclerViewAdapterTicketInfo();
        mRecyclerView.setAdapter(mRecyclerViewAdapterTicketInfo);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showTicketInfo(Body mBody) {
        mRecyclerViewAdapterTicketInfo.setTiketInfo(mBody.getTicket());

        mFreeSeats.setText(String.valueOf(mBody.getFreeseats()) + " " + "/" + " ");
        mMaxSeats.setText(String.valueOf(mBody.getMaxseats()));
        mDispatchStation.setText("Белокуриха" + " " + "-");
        mArrivalStation.setText("Барнаул");
        mDriverTimeOut.setText("11:30");
        mDriverInn.setText(mBody.getCarrier().getInn());
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(ProgressBar.GONE);
    }

}
