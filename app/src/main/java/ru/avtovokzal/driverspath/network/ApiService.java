package ru.avtovokzal.driverspath.network;


import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private Retrofit mRetrofit;
    private static ApiService sInstance;
    private OkHttpClient okHttpClient;

    private ApiService(Context context, String URL) {
        okHttpClient = buildOkHttp();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getsInstance(Context context, String URL) {
        if (sInstance == null) {
            synchronized (ApiService.class) {
                if (sInstance == null) {
                    sInstance = new ApiService(context, URL);
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
