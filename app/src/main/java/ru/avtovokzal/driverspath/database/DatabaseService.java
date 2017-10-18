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
        body.setmId(0);
        body.getCarrier().setmId(0);
        mDatabaseHelper.getBodyDao().createOrUpdate(body);
        mDatabaseHelper.getCarrierDao().createOrUpdate(body.getCarrier());


        for (int i = 0; i < body.getTicket().size(); i++) {
            body.getTicket().get(i).setmId(i);
            body.getTicket().get(i).getPassenger().setmId(i);
            mDatabaseHelper.getTicketDao().createOrUpdate((Ticket) body.getTicket());
            mDatabaseHelper.getPassengerDao().createOrUpdate(body.getTicket().get(i).getPassenger());
        }
    }
}
