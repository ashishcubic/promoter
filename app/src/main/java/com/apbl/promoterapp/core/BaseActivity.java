package com.apbl.promoterapp.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.apbl.promoterapp.R;
import com.apbl.promoterapp.core.network.RetrofitAPIProvider;
import com.apbl.promoterapp.network.PromotorClient;

import retrofit2.Retrofit;


public abstract class BaseActivity extends AppCompatActivity implements BaseLifecycle.View {

    public Context context;

    protected abstract BaseLifecycle.ViewModel getViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.context = this;

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getViewModel() != null)
            getViewModel().onViewAttached(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (getViewModel() != null)
            getViewModel().onViewDetached();
    }

    /**
     * Used for hitting the api
     */
    public Retrofit getRetrofit() {
        return RetrofitAPIProvider.getInstance().getRetrofit();
    }

    public PromotorClient createService() {

        return getRetrofit().create(PromotorClient.class);
    }

    public void openFragment(Fragment frag, String tag, int container) {
        openFragment(frag, null, tag, container);
    }

    public void openFragment(Fragment frag, Bundle bundle, String tag, int container) {
        if (bundle != null) {
            frag.setArguments(bundle);
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack(tag);
        ft.replace(container, frag, tag);
        ft.commit();
    }

    @Override
    public void openActivity(Intent intent) {
        startActivity(intent);

    }

    @Override
    public void openActivityForResult(Intent intent, int requestCode) {

    }
}
