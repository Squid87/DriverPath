package ru.avtovokzal.driverspath.database;


import android.content.Context;

import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ru.avtovokzal.driverspath.stations.model.In;
import ru.avtovokzal.driverspath.stations.model.Out;
import ru.avtovokzal.driverspath.stations.model.Stops;
import ru.avtovokzal.driverspath.tickets.model.Body;
import ru.avtovokzal.driverspath.tickets.model.Carrier;
import ru.avtovokzal.driverspath.tickets.model.Passenger;
import ru.avtovokzal.driverspath.tickets.model.Ticket;

public class DatabaseService {

	private DatabaseHelper mDatabaseHelper;

	public DatabaseService(Context context) {
		mDatabaseHelper = DatabaseHelper.getInstance(context);
	}

	public void saveTickets(Body body) throws SQLException {

		List<Ticket> mTickets = new ArrayList<>(body.getTicket());
		body.setId(1);
		body.getCarrier().setId(1);
		mDatabaseHelper.getBodyDao().createOrUpdate(body);
		mDatabaseHelper.getCarrierDao().createOrUpdate(body.getCarrier());

		for (int i = 0; i < mTickets.size(); i++) {
			mTickets.get(i).setId(i);
			mTickets.get(i).getPassenger().setId(i);
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
			mStop.setId(i);
			if (mStop.getIn() != null) {
				for (In mIn : mStop.getIn()) {
					mIn.setParentStops(mStop);
					mDatabaseHelper.getPassengerStationDao().createOrUpdate(mIn.getPassenger());
					mDatabaseHelper.getInDao().createOrUpdate(mIn);
					mDatabaseHelper.getPassengerStationDao().createOrUpdate(mIn.getPassenger());
				}
			}
			if (mStop.getOut() != null) {
				for (Out mOut : mStop.getOut()) {
					mOut.setParentStops(mStop);
					mDatabaseHelper.getPassengerStationDao().createOrUpdate(mOut.getPassenger());
					mDatabaseHelper.getOutDao().createOrUpdate(mOut);
				}
			}
			mDatabaseHelper.getStopsDao().createOrUpdate(mStop);
		}

	}

	public List<Stops> loadStops() throws SQLException {
		return mDatabaseHelper.getStopsDao().queryForAll();
	}

	public void deleteDatabaseStations() throws SQLException {

		DeleteBuilder<Stops, Integer> deleteStops = mDatabaseHelper.getStopsDao().deleteBuilder();
		deleteStops.delete();

		DeleteBuilder<In, Integer> deleteIn = mDatabaseHelper.getInDao().deleteBuilder();
		deleteIn.delete();

		DeleteBuilder<Out, Integer> deleteOut = mDatabaseHelper.getOutDao().deleteBuilder();
		deleteOut.delete();

		DeleteBuilder<ru.avtovokzal.driverspath.stations.model.Passenger, Integer> deletePassengerStation = mDatabaseHelper.getPassengerStationDao().deleteBuilder();
		deletePassengerStation.delete();
	}

}
