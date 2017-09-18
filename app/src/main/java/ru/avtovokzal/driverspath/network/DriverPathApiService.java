package ru.avtovokzal.driverspath.network;


import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DriverPathApiService {
    private String BASE_URL = "http://webapp.avtovokzal.ru";
    private Retrofit mRetrofit;
    private static DriverPathApiService sInstance;

    private DriverPathApiService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static DriverPathApiService getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (DriverPathApiService.class) {
                if (sInstance == null) {
                    sInstance = new DriverPathApiService(context);
                }
            }
        }
        return sInstance;
    }

    public DriverPathApiInterface createApi() {
        return mRetrofit.create(DriverPathApiInterface.class);
    }
}
