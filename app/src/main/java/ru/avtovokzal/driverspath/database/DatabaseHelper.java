package ru.avtovokzal.driverspath.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import ru.avtovokzal.driverspath.modelTickets.Body;
import ru.avtovokzal.driverspath.modelTickets.Carrier;
import ru.avtovokzal.driverspath.modelTickets.Passenger;
import ru.avtovokzal.driverspath.modelTickets.Ticket;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static String TAG = "DatabaseHelper1";

    private static final String DATABASE_NAME = "DriverDataBase.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper mDataBaseHelper;

    private Dao<Body, Integer> dBody;
    private Dao<Carrier, Integer> dCarrier;
    private Dao<Ticket, Integer> dTicket;
    private Dao<Passenger, Integer> dPassenger;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //синглтон для Хелпера
    public static DatabaseHelper getInstance(Context context) {
        if (mDataBaseHelper == null) {
            synchronized (DatabaseHelper.class) {
                if (mDataBaseHelper == null) {
                    mDataBaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
                }
            }
        }
        return mDataBaseHelper;
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Body.onCreate(database, connectionSource);
            Carrier.onCreate(database, connectionSource);
            Ticket.onCreate(database, connectionSource);
            Passenger.onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<Body, Integer> getBodyDao() throws SQLException {
        if (dBody == null) {
            dBody = getDao(Body.class);
        }
        return dBody;
    }

    public Dao<Carrier, Integer> getCarrierDao() throws SQLException {
        if (dCarrier == null) {
            dCarrier = getDao(Carrier.class);
        }
        return dCarrier;
    }

    public Dao<Ticket, Integer> getTicketDao() throws SQLException {
        if (dTicket == null) {
            dTicket = getDao(Ticket.class);
        }
        return dTicket;
    }

    public Dao<Passenger, Integer> getPassengerDao() throws SQLException {
        if (dPassenger == null) {
            dPassenger = getDao(Passenger.class);
        }
        return dPassenger;
    }
}
