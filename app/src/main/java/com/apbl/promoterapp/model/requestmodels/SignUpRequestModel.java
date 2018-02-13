package com.apbl.promoterapp.model.requestmodels;

import com.apbl.promoterapp.core.model.BaseRequestModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by a1nc1l1v on 1/25/2018.
 */

public class SignUpRequestModel extends BaseRequestModel {


    @SerializedName(value = "retailerId")
    private String retailerId;

    @SerializedName(value = "password")
    private String password;

    @SerializedName(value = "confirmPassword")
    private String confirmPassword;

    @SerializedName(value = "validateToken")
    private String validateToken;

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getValidateToken() {
        return validateToken;
    }

    public void setValidateToken(String validateToken) {
        this.validateToken = validateToken;
    }
}
