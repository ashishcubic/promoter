package com.apbl.promoterapp.screens.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.apbl.promoterapp.R;
import com.apbl.promoterapp.core.BaseActivity;
import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.screens.fragments.FragmentCreateAcount;
import com.apbl.promoterapp.util.Constants;
import com.apbl.promoterapp.util.LocalPreferences;

import java.security.SecureRandom;


public class LoginActivity extends BaseActivity {

    private LocalPreferences localPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        localPreferences = new LocalPreferences(this);

        checkLocalPreferences();

    }

    private void checkLocalPreferences() {

        localPreferences.saveAppVersion(getAppVersion());
        localPreferences.saveDeviceID(getUniqueId());
        /*if (localPreferences.getSessionID() != null) {

        } else {

            init();
        }*/

        init();
    }


    private void init() {
        openFragment(new FragmentCreateAcount(), Constants.Login.Title.LOGIN, R.id.frag_container);
    }

    @Override
    protected BaseLifecycle.ViewModel getViewModel() {
        return null;
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        int backStackEntryCount = fm.getBackStackEntryCount();
        if (backStackEntryCount == 1) {
            this.finish();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }


    public String getAppVersion() {

        try {
            PackageInfo pInfo = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;

        }
    }



    public String getUniqueId() {
        return Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }
}
