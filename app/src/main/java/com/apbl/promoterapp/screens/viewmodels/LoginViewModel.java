package com.apbl.promoterapp.screens.viewmodels;


import android.content.Context;
import android.support.annotation.NonNull;

import com.apbl.promoterapp.core.BaseActivity;
import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.core.network.RestCallback;
import com.apbl.promoterapp.core.network.RestProcess;
import com.apbl.promoterapp.core.util.Toaster;
import com.apbl.promoterapp.model.TokenDTO;
import com.apbl.promoterapp.model.TokenResponseDTO;
import com.apbl.promoterapp.model.requestmodels.LoginRequestModel;
import com.apbl.promoterapp.model.requestmodels.OtpVerifyRequestModel;
import com.apbl.promoterapp.model.requestmodels.VerifyLAPUModel;
import com.apbl.promoterapp.model.responsemodels.VerifuLAPUResponse;
import com.apbl.promoterapp.network.PromotorClient;
import com.apbl.promoterapp.screens.LoginContract;

import java.security.SecureRandom;

import retrofit2.Response;

public class LoginViewModel implements LoginContract.ViewModel {

    public LoginContract.View viewCallback;
    private Context context;
    private LoginRequestModel loginRequestModel;
    private OtpVerifyRequestModel otpVerifyRequestModel;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewAttached(@NonNull BaseLifecycle.View viewCallback) {
        this.viewCallback = (LoginContract.View) viewCallback;
    }

    @Override
    public void onViewDetached() {
        this.viewCallback = null;
    }

    public String sessionId() {

        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        sb.append("RETAP");

        for (int i = 0; i < 10; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    /*@Override
    public void onApiFailure(Throwable e, int serviceMode) {
        if (viewCallback != null) {
            viewCallback.onFailure(serviceMode, "Login Failure");
        }

        Toaster.shortToast("Login Failure");

    }

    @Override
    public void onApiSuccess(Response response, int serviceMode) {
        if (viewCallback != null) {
            viewCallback.onSuccess(serviceMode);
        }

        Toaster.shortToast("onApiSuccess");

    }*/

    @Override
    public void login(int serviceMode) {

    }

    @Override
    public void verifyLAPU(VerifyLAPUModel verifyLAPUModel) {

    }

   /*@Override
    public void login(int serviceMode) {
        PromotorClient promotorClient = ((BaseActivity) context).createService();
        TokenDTO dto = new TokenDTO();
        dto.setChannel("RAPP");
        dto.setJwtExpiry("29400");
        dto.setVer("2.7");
        dto.setLanguageId("001");
        dto.setFeSessionId(sessionId());
        dto.setRetailerId("9910068579");
        dto.setActorType("RET");
        new RestProcess<TokenResponseDTO>(context, this, serviceMode, true)
                .makeApiRequest(promotorClient.generateToken(dto));
    }*/

   /* @Override
    public void verifyLAPU(VerifyLAPUModel verifyLAPUModel) {
        PromotorClient promotorClient = ((BaseActivity) context).createService();

        new RestProcess<VerifuLAPUResponse>(context, this, 1, true)
                .makeApiRequest(promotorClient.verifyLAPU(verifyLAPUModel));

    }*/

    //provide only getter for the model to prevent direct replacement
    public LoginRequestModel getLoginRequestModel() {
        return loginRequestModel;
    }

    public OtpVerifyRequestModel getOtpVerifyRequestModel() {
        return otpVerifyRequestModel;
    }

}
