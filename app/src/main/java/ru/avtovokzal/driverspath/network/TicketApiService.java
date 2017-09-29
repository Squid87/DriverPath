package ru.avtovokzal.driverspath.network;


import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Observable;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;

public class TicketApiService {
    private String BASE_URL = "http://webapp.avtovokzal.ru";
    private Retrofit mRetrofit;
    private static TicketApiService sInstance;
    private OkHttpClient okHttpClient;

    private TicketApiService(Context context) {
        okHttpClient = buildOkHttp();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
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

    private OkHttpClient buildOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(chain -> {
            Response response = chain.proceed(chain.request());
            return response;
        });
        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .build();
            return chain.proceed(request);
        });
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor).build();

        return builder.build();
    }

    public TicketApiInterface createApi() {
        return mRetrofit.create(TicketApiInterface.class);
    }
}
