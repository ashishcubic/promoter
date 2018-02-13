package com.apbl.promoterapp.core.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sunny on 1/11/2018.
 */

public class BaseResponseModel {

    @SerializedName(value = "code")
    private String code;

    @SerializedName(value = "errorCode")
    private String errorCode;

    @SerializedName(value = "messageText")
    private String messageText;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
