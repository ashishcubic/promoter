package com.apbl.promoterapp.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.apbl.promoterapp.screens.activity.LoginActivity;

import java.util.HashMap;


public class SessionManager {
    public static final String KEY_USER_ID = "u_id";
    public static final String KEY_DEVICE_ID = "g_u_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_GCM_REG_ID = "gcm_regid";
    public static final String KEY_IMAGE_URL = "image_url";
    private static final String PREF_NAME = "PromoterPref";
    private static final String IS_LOGIN = "IsLoggedIn";

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private Context _context;

    private int PRIVATE_MODE = 0;


    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public static boolean isAttendanceTaken() {
        return false;
    }


    public void createLoginSession(String user_id, String device_id, String name, String email, String gcm_id, String image_url) {

        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_USER_ID, user_id);
        editor.putString(KEY_DEVICE_ID, device_id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_GCM_REG_ID, gcm_id);
        editor.putString(KEY_IMAGE_URL, image_url);

        editor.commit();
    }

    public void checkLogin() {

        if (!this.isLoggedIn()) {

            Intent i = new Intent(_context, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(i);
        }

    }

    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        return user;
    }

    public String getUserId() {
        return pref.getString(KEY_USER_ID, null);
    }

    public String getUserName() {
        return pref.getString(KEY_NAME, null);
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(_context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }
}