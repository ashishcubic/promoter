package com.apbl.promoterapp.screens.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.apbl.promoterapp.R;
import com.apbl.promoterapp.constant.AppConstant;
import com.apbl.promoterapp.core.BaseActivity;
import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.util.Constants;

/**
 * Created by Sunny on 12/28/2017.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected BaseLifecycle.ViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                SplashActivity.this.finish();
            }
        }, AppConstant.Splash.DEFAULT_TIME);
    }
}
