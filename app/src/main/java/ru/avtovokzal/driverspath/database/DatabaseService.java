package ru.avtovokzal.driverspath.database;


import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.avtovokzal.driverspath.model.Body;
import ru.avtovokzal.driverspath.model.Ticket;

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

}
