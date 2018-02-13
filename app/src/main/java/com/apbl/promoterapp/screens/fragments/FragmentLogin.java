package com.apbl.promoterapp.screens.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apbl.promoterapp.R;
import com.apbl.promoterapp.core.BaseActivity;
import com.apbl.promoterapp.core.BaseFragment;
import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.util.Constants;
import com.apbl.promoterapp.util.Util;

public class FragmentLogin extends BaseFragment implements View.OnClickListener {

    private View mView;
    private TextInputLayout numInputLay, pwdInputLay, confirmPwdInputLay;
    private TextView mLapuNo,mPsw,mConfirmPsw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_same_device, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        init();
    }

    private void init() {
        numInputLay = (TextInputLayout) mView.findViewById(R.id.input_layout_frag_login_num);
        pwdInputLay = (TextInputLayout) mView.findViewById(R.id.input_layout_frag_login_psw);
        mView.findViewById(R.id.btn_login).setOnClickListener(this);


    }

    @Override
    protected BaseLifecycle.ViewModel getViewModel() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                ((BaseActivity) getContext()).openFragment(new FragmentLoginDifferentDevice(), null,
                        Constants.Login.Title.LOGIN_MOBILE_NUM, R.id.frag_container);
                break;
            default:
                break;
        }
    }

    private void doData() {

        if (!Util.getInstance().isValidInputTextField(pwdInputLay, getString(R.string.empty_pwd))) {
            return;
        }

    }
}
