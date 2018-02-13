package com.apbl.promoterapp.model.responsemodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by peddiraju on 12/2/18.
 */

public class VerifuLAPUResponse {

    @SerializedName(value = "feSessionId")
    private String feSessionId;

    @SerializedName(value = "code")
    private String code;

    @SerializedName(value = "errorCode")
    private String errorCode;

    @SerializedName(value = "messageText")
    private String messageText;

    public String getFeSessionId() {
        return feSessionId;
    }

    public void setFeSessionId(String feSessionId) {
        this.feSessionId = feSessionId;
    }

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
