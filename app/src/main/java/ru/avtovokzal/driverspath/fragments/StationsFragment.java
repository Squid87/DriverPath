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
import ru.avtovokzal.driverspath.modelStation.StationTicket;
import ru.avtovokzal.driverspath.modelStation.Stops;
import ru.avtovokzal.driverspath.mvp.StationInfoPresenter;
import ru.avtovokzal.driverspath.mvp.View.StationInformationView;


public class StationsFragment extends MvpAppCompatFragment implements StationInformationView {

	private List<StationTicket> mStationTickets = new ArrayList<>();

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

			List<StationTicket> stationTickets = new ArrayList<>();

			Collection<In> in = stop.getIn();
			Collection<Out> out = stop.getOut();

			if (in != null) {
				for (In item : in) {
					stationTickets.add(createTicketIn(item));
				}
			}
			if (out != null) {
				for (Out item : out) {
					stationTickets.add(createTicketOut(item));
				}
			}
			StationCollector stationCollector = new StationCollector(stop, new ArrayList<>(stationTickets));
			mStationCollectors.add(stationCollector);
			mStationTickets.addAll(stationTickets);
		}
		mStationAdapter = new StationAdapter(mStationCollectors);
		mStationRecyclerView.setAdapter(mStationAdapter);

		mStationAdapter.setListener(position -> {
			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.activity_main_conteiner, new PassengerInfoFragment(position,mStationTickets))
					.addToBackStack(null)
					.commit();
			getActivity().getSupportFragmentManager().executePendingTransactions();
		});

	}

	private StationTicket createTicketOut(Out item) {
		StationTicket stationTicket = new StationTicket();
		stationTicket.mSeatnum = item.mSeatnum;
		stationTicket.setPassenger(item.mPassenger);
		stationTicket.mDispatchstationname = item.mDispatchstationname;
		stationTicket.mArrivalstationname = item.mArrivalstationname;
		stationTicket.direction = "OUT";
		return stationTicket;
	}

	private StationTicket createTicketIn(In item) {
		StationTicket stationTicket = new StationTicket();
		stationTicket.mSeatnum = item.mSeatnum;
		stationTicket.setPassenger(item.mPassenger);
		stationTicket.mDispatchstationname = item.mDispatchstationname;
		stationTicket.mArrivalstationname = item.mArrivalstationname;
		stationTicket.direction = "IN";
		return stationTicket;
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
