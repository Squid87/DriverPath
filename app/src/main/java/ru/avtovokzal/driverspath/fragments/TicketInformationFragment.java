package ru.avtovokzal.driverspath.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.avtovokzal.driverspath.R;
import ru.avtovokzal.driverspath.adapters.RecyclerViewAdapterTicketInfo;
import ru.avtovokzal.driverspath.adapters.RecyclerViewTicketInfoHolder;
import ru.avtovokzal.driverspath.model.TicketInfo;
import ru.avtovokzal.driverspath.mvp.TicketInfoPresenter;
import ru.avtovokzal.driverspath.mvp.View.TicketInformationView;

public class TicketInformationFragment extends MvpAppCompatFragment implements TicketInformationView {

    @InjectPresenter
    TicketInfoPresenter mTicketInfoPresenter;

    RecyclerViewAdapterTicketInfo mRecyclerViewAdapterTicketInfo;

    @BindView(R.id.fragment_ticket_info_recycler_view)
    RecyclerView mRecyclerView;

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
    public void showTicketInfo(List<TicketInfo> ticketInfo) {
        mRecyclerViewAdapterTicketInfo.setTiketInfo(ticketInfo);
    }
}
