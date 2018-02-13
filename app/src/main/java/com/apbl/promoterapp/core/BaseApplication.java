package com.apbl.promoterapp.core;

import android.app.Application;

import java.util.HashMap;


public abstract class BaseApplication extends Application {

    private static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    public abstract String getBaseUrl();

    /**
     * Description : Add all the default headers in HashMap
     *
     * @return
     */
    public abstract HashMap<String, String> getHeaders();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
