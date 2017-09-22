package ru.avtovokzal.driverspath;


public class Application extends android.app.Application{
    private static Application sInstance;
    public static Application getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

}
