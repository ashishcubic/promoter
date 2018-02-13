package com.apbl.promoterapp.core.network;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by a1nc1l1v on 1/25/2018.
 */

public class RetrofitAPIProvider {

    private static final String BASE_URL = "http://promoterapp.ap-south-1.elasticbeanstalk.com/api/";
    private static Retrofit retrofit = null;

    private static RetrofitAPIProvider ourInstance = null;

    public static RetrofitAPIProvider getInstance() {
        if (ourInstance == null) {
            ourInstance = new RetrofitAPIProvider();
        }
        return ourInstance;
    }


    public Retrofit getRetrofit() {
        return (retrofit == null) ? setRetrofit() : retrofit;
    }

    public Retrofit setRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(provideClient(false))
                .build();

        return retrofit;
    }

    private OkHttpClient provideClient(final boolean isAuthorized) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(90, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);

        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder();

                HttpUrl url = request.url()
                        .newBuilder()
                        .build();

             /*  if (getHeaders() != null) {
                   for (Map.Entry<String, String> map : getHeaders().entrySet())
                      requestBuilder.addHeader(map.getKey(), map.getValue());
                }
*/
                if (isAuthorized) {

                    //for post login api's
                    request = requestBuilder.url(url).build();

                } else {

                    //for pre login api's
                    request = requestBuilder.url(url).build();
                }

                return chain.proceed(request);
            }
        });
/*
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);*/
        return builder.build();
    }
}
