package com.apbl.promoterapp.screens.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.apbl.promoterapp.R;
import com.apbl.promoterapp.core.BaseActivity;
import com.apbl.promoterapp.core.BaseFragment;
import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.core.util.DialogUtil;
import com.apbl.promoterapp.core.util.Toaster;
import com.apbl.promoterapp.screens.LoginContract;
import com.apbl.promoterapp.screens.viewmodels.LoginViewModel;
import com.apbl.promoterapp.util.Constants;
import com.apbl.promoterapp.util.Util;

public class FragmentCreatePassword extends BaseFragment implements View.OnClickListener, LoginContract.View {

    BaseLifecycle.ViewModel viewModel;
    private LoginContract.ViewModel loginViewModel;
    private View mView;
    private TextInputLayout mobileNumInputLayout, otpInputLayout, pwdInputLayout;


    @Override
    protected BaseLifecycle.ViewModel getViewModel() {
        return loginViewModel;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginViewModel = new LoginViewModel(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_password, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        init();

    }

    private void init() {
        mobileNumInputLayout = (TextInputLayout) mView.findViewById(R.id.input_layout_frag_login_lapu_num);
        otpInputLayout = (TextInputLayout) mView.findViewById(R.id.input_layout_frag_login_otp);
        Button btnLogin = (Button) mView.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                ((BaseActivity) getContext()).openFragment(new FragmentLogin(), null,
                        Constants.Login.Title.LOGIN_MOBILE_NUM, R.id.frag_container);
                break;

            default:
                break;
        }
    }


    @Override
    public void onSuccess(int serviceMode) {

    }

    @Override
    public void onFailure(int serviceMode, String msg) {

    }
 }
