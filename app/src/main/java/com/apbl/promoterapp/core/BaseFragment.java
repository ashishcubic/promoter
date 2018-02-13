package com.apbl.promoterapp.core;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment implements BaseLifecycle.View {

    public Context context;

    protected abstract BaseLifecycle.ViewModel getViewModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();
    }

    /* public Retrofit getRetrofit() {
         return ((BaseApplication) getActivity().getApplicationContext()).getRetrofit();
     }
 */
    @Override
    public void onResume() {
        super.onResume();
        if (getViewModel() != null)
        getViewModel().onViewResumed();
    }

    @Override
    public void onStart() {

        super.onStart();
        if (getViewModel() != null)
            getViewModel().onViewAttached(this);
    }

    @Override
    public void onStop() {

        super.onStop();
        if (getViewModel() != null)
            getViewModel().onViewDetached();
    }

    @Override
    public void openFragment(Fragment frag, Bundle bundle, String tag, int container) {

    }

    @Override
    public void openActivity(Intent intent) {

    }

    @Override
    public void openActivityForResult(Intent intent, int requestCode) {

    }
}
