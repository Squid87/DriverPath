package ru.avtovokzal.driverspath.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

import ru.avtovokzal.driverspath.modelStation.In;
import ru.avtovokzal.driverspath.modelStation.Out;
import ru.avtovokzal.driverspath.modelStation.Stops;
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
    private Dao<Passenger, Integer> dPassengerTicket;
    private Dao<ru.avtovokzal.driverspath.modelStation.Passenger, Integer> dPassengerStation;

    private Dao<Stops, Integer> dStops;
    private Dao<In, Integer> dIn;
    private Dao<Out, Integer> dOut;


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
            //Create Tickets Table
            Body.onCreate(database, connectionSource);
            Carrier.onCreate(database, connectionSource);
            Ticket.onCreate(database, connectionSource);
            Passenger.onCreate(database, connectionSource);

            //Create Station Table
            Stops.onCreate(database, connectionSource);
            In.onCreate(database, connectionSource);
            Out.onCreate(database, connectionSource);
            ru.avtovokzal.driverspath.modelStation.Passenger.onCreate(database, connectionSource);

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
        if (dPassengerTicket == null) {
            dPassengerTicket = getDao(Passenger.class);
        }
        return dPassengerTicket;
    }

    public Dao<Stops, Integer> getStopsDao() throws SQLException {
        if (dStops == null) {
            dStops = getDao(Stops.class);
        }
        return dStops;
    }

    public Dao<In, Integer> getInDao() throws SQLException {
        if (dIn == null) {
            dIn = getDao(In.class);
        }
        return dIn;
    }

    public Dao<Out, Integer> getOutDao() throws SQLException {
        if (dOut == null) {
            dOut = getDao(Out.class);
        }
        return dOut;
    }

    public Dao<ru.avtovokzal.driverspath.modelStation.Passenger, Integer> getPassengerStationDao() throws SQLException {
        if (dPassengerStation == null) {
            dPassengerStation = getDao(ru.avtovokzal.driverspath.modelStation.Passenger.class);
        }
        return dPassengerStation;
    }
}
