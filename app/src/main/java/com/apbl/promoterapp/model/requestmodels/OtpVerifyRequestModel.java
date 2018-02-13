package com.apbl.promoterapp.model.requestmodels;

import com.apbl.promoterapp.core.model.BaseRequestModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by a1nc1l1v on 1/25/2018.
 */

public class OtpVerifyRequestModel extends BaseRequestModel {

    @SerializedName(value = "otp")
    private String otp;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
