package ru.avtovokzal.driverspath.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.adaptersStation.StationAdapter;
import ru.avtovokzal.driverspath.modelStation.In;
import ru.avtovokzal.driverspath.modelStation.Out;
import ru.avtovokzal.driverspath.modelStation.StationCollector;
import ru.avtovokzal.driverspath.modelStation.Stops;
import ru.avtovokzal.driverspath.modelStation.Ticket;
import ru.avtovokzal.driverspath.mvp.StationInfoPresenter;
import ru.avtovokzal.driverspath.mvp.View.StationInformationView;


public class StationsFragment extends MvpAppCompatFragment implements StationInformationView {

    @InjectPresenter
    StationInfoPresenter mStationInfoPresenter;

    StationAdapter mStationAdapter;

    @BindView(R.id.station_progress_bar)
    ProgressBar mStationProgressBar;

    @BindView(R.id.fragment_station_info_recycler_view)
    RecyclerView mStationRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_station_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mStationRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showStations(Collection<Stops> station) {
        List<StationCollector> mStationCollectors = new ArrayList<>();

        for (Stops stop : station) {

            List<Ticket> tickets = new ArrayList<>();

            Collection<In> in = stop.getIn();
            Collection<Out> out = stop.getOut();

            if (in != null) {
                for (In item : in) {
                    tickets.add(createTicketIn(item));
                }
            }
            if (out != null) {
                for (Out item : out) {
                    tickets.add(createTicketOut(item));
                }
            }
            StationCollector stationCollector = new StationCollector(stop, new ArrayList<>(tickets));
            mStationCollectors.add(stationCollector);
        }
        mStationAdapter = new StationAdapter(mStationCollectors);
        mStationRecyclerView.setAdapter(mStationAdapter);

    }

    private Ticket createTicketOut(Out item) {
        Ticket ticket = new Ticket();
        ticket.mSeatnum = item.mSeatnum;
        ticket.mDispatchstationname = item.mDispatchstationname;
        ticket.mArrivalstationname = item.mArrivalstationname;
        ticket.direction = "OUT";
        return ticket;
    }

    private Ticket createTicketIn(In item) {
        Ticket ticket = new Ticket();
        ticket.mSeatnum = item.mSeatnum;
        ticket.mDispatchstationname = item.mDispatchstationname;
        ticket.mArrivalstationname = item.mArrivalstationname;
        ticket.direction = "IN";
        return ticket;
    }

    @Override
    public void showProgressBar() {
        mStationProgressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mStationProgressBar.setVisibility(ProgressBar.GONE);
    }
}
