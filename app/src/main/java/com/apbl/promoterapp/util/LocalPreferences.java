package com.apbl.promoterapp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.apbl.promoterapp.R;


public class LocalPreferences {

    private final SharedPreferences pref;
    private final Context context;
    private final SharedPreferences.Editor editor;

    public LocalPreferences(Context mcontext) {
        context = mcontext;
        pref = mcontext.getSharedPreferences(mcontext.getString(R.string.LOCAL_PREF), Context.MODE_PRIVATE);
        editor = pref.edit();
    }


    public void saveSessionID(String auth) {
        editor.putString(context.getString(R.string.LOCAL_SESSIONID), auth);
        editor.apply();
    }


    public String getSessionID() {
        return pref.getString(context.getString(R.string.LOCAL_SESSIONID), null);
    }


    public void saveAppVersion(String auth) {
        editor.putString(context.getString(R.string.LOCAL_APPVERSION), auth);
        editor.apply();
    }

    public String getAppVersion() {
        return pref.getString(context.getString(R.string.LOCAL_APPVERSION), null);
    }

    public void saveDeviceID(String auth) {
        editor.putString(context.getString(R.string.LOCAL_DEVICEID), auth);
        editor.apply();
    }

    public String getDeviceID() {
        return pref.getString(context.getString(R.string.LOCAL_DEVICEID), null);
    }


}
