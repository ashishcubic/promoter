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
import com.apbl.promoterapp.core.BaseFragment;
import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.util.Util;

public class FragmentLoginDifferentDevice extends BaseFragment implements View.OnClickListener {

    private View mView;
    private TextInputLayout otpInputLay, pwdInputLay, confirmPwdInputLay;
    private TextView mLapuNo,mPsw,mConfirmPsw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_diff_device, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        init();
    }

    private void init() {

    }

    @Override
    protected BaseLifecycle.ViewModel getViewModel() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                doData();
                break;
            default:
                break;
        }
    }

    private void doData() {
        if (!Util.getInstance().isValidInputTextField(otpInputLay, getString(R.string.empty_otp))) {
            return;
        }
        if (!Util.getInstance().isValidInputTextField(pwdInputLay, getString(R.string.empty_pwd))) {
            return;
        }
        if (!Util.getInstance().isValidInputTextField(confirmPwdInputLay, getString(R.string.empty_confirm_pwd))) {
            return;
        }
        if (!Util.getInstance().isPasswordMatch(pwdInputLay, confirmPwdInputLay, getString(R.string.pwd_mismatch))) {
            return;
        }
        if( this.mLapuNo.getText().toString().length() != 10) {
            Util.getInstance().setInputLayoutError(otpInputLay,getString(R.string.valid_lapu_no));
           // Toaster.shortToast(R.string.valid_lapu_no);
            return;
        }



    }
}
