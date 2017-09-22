package ru.avtovokzal.driverspath.network;


import android.content.Context;

import java.util.Observable;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;

public class TicketApiService {
    private String BASE_URL = "http://webapp.avtovokzal.ru";
    private Retrofit mRetrofit;
    private static TicketApiService sInstance;

    private TicketApiService(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static TicketApiService getsInstance(Context context) {
        if (sInstance == null) {
            synchronized (TicketApiService.class) {
                if (sInstance == null) {
                    sInstance = new TicketApiService(context);
                }
            }
        }
        return sInstance;
    }

    public TicketApiInterface createApi() {
        return mRetrofit.create(TicketApiInterface.class);
    }
}
