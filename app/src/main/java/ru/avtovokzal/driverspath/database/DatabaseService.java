package ru.avtovokzal.driverspath.database;


import android.content.Context;

import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.avtovokzal.driverspath.modelStation.In;
import ru.avtovokzal.driverspath.modelStation.Out;
import ru.avtovokzal.driverspath.modelStation.Stops;
import ru.avtovokzal.driverspath.modelTickets.Body;
import ru.avtovokzal.driverspath.modelTickets.Carrier;
import ru.avtovokzal.driverspath.modelTickets.Passenger;
import ru.avtovokzal.driverspath.modelTickets.Ticket;

public class DatabaseService {

    private DatabaseHelper mDatabaseHelper;

    public DatabaseService(Context context) {
        mDatabaseHelper = DatabaseHelper.getInstance(context);
    }

    public void saveTickets(Body body) throws SQLException {

        List<Ticket> mTickets = new ArrayList<>(body.getTicket());
        body.setmId(1);
        body.getCarrier().setmId(1);
        mDatabaseHelper.getBodyDao().createOrUpdate(body);
        mDatabaseHelper.getCarrierDao().createOrUpdate(body.getCarrier());

        for (int i = 0; i < mTickets.size(); i++) {
            mTickets.get(i).setmId(i);
            mTickets.get(i).getPassenger().setmId(i);
            mTickets.get(i).setParentBodyId(body);
            mDatabaseHelper.getTicketDao().createOrUpdate(mTickets.get(i));
            mDatabaseHelper.getPassengerDao().createOrUpdate(mTickets.get(i).getPassenger());
        }

    }

    public Body loadTickets() throws SQLException {
        return mDatabaseHelper.getBodyDao().queryForId(1);
    }

    public void deleteDatabaseTicket() throws SQLException {

        DeleteBuilder<Body, Integer> deleteBody = mDatabaseHelper.getBodyDao().deleteBuilder();
        deleteBody.delete();

        DeleteBuilder<Carrier, Integer> deleteCarrier = mDatabaseHelper.getCarrierDao().deleteBuilder();
        deleteCarrier.delete();

        DeleteBuilder<Ticket, Integer> deleteTicket = mDatabaseHelper.getTicketDao().deleteBuilder();
        deleteTicket.delete();

        DeleteBuilder<Passenger, Integer> deletePassenger = mDatabaseHelper.getPassengerDao().deleteBuilder();
        deletePassenger.delete();
    }

    public void saveStops(Collection<Stops> stops) throws SQLException {

        List<Stops> mStops = new ArrayList<>(stops);

        for (int i = 0; i < mStops.size(); i++) {
            Stops mStop = mStops.get(i);
            mStop.setmId(i);
            if (mStop.getIn() != null) {
                for (In mIn : mStop.getIn()) {
                    mIn.setParentStops(mStop);
                    mDatabaseHelper.getInDao().createOrUpdate(mIn);
                }
            }
            if (mStop.getOut() != null) {
                for (Out mOut : mStop.getOut()) {
                    mOut.setParentStops(mStop);
                    mDatabaseHelper.getOutDao().createOrUpdate(mOut);
                }
            }
            mDatabaseHelper.getStopsDao().createOrUpdate(mStop);
        }

    }

    public List<Stops> loadStops() throws SQLException {
        return mDatabaseHelper.getStopsDao().queryForAll();
    }

    public void deleteDatabaseStatons() throws SQLException {

        DeleteBuilder<Stops, Integer> deleteStops = mDatabaseHelper.getStopsDao().deleteBuilder();
        deleteStops.delete();

        DeleteBuilder<In, Integer> deleteIn = mDatabaseHelper.getInDao().deleteBuilder();
        deleteIn.delete();

        DeleteBuilder<Out, Integer> deleteOut = mDatabaseHelper.getOutDao().deleteBuilder();
        deleteOut.delete();
    }

}
