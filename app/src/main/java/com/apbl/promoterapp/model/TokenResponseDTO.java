package com.apbl.promoterapp.model;

import com.google.gson.annotations.SerializedName;

public class TokenResponseDTO {

    @SerializedName(value = "code")
    private String code;

    @SerializedName(value = "feSessionId")
    private String feSessionId;

    @SerializedName(value = "actorType")
    private String actorType;

    @SerializedName(value = "status")
    private String status;

    @SerializedName(value = "currentBal")
    private String currentBal;

    @SerializedName(value = "errorCode")
    private String errorCode;

    @SerializedName(value = "messageText")
    private String messageText;

    @SerializedName(value = "token")
    private String token;

    @SerializedName(value = "Name")
    private String name;

    @SerializedName(value = "isBdayWeek")
    private boolean isBdayWeek;

    @SerializedName(value = "isBdayDay")
    private boolean isBdayDay;

    @SerializedName(value = "lastLogin")
    private String lastLogin;

    @SerializedName(value = "enableEncryption")
    private boolean enableEncryption;

    @SerializedName(value = "endChannel")
    private String endChannel;

    @SerializedName(value = "errorMessage")
    private String errorMessage;

    @SerializedName(value = "latlongAvailable")
    private String latlongAvailable;

    public String getLatlongAvailable() {
        return latlongAvailable;
    }

    public void setLatlongAvailable(String latlongAvailable) {
        this.latlongAvailable = latlongAvailable;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBdayWeek() {
        return isBdayWeek;
    }

    public void setIsBdayWeek(boolean isBdayWeek) {
        this.isBdayWeek = isBdayWeek;
    }

    public boolean isBdayDay() {
        return isBdayDay;
    }

    public void setIsBdayDay(boolean isBdayDay) {
        this.isBdayDay = isBdayDay;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getFeSessionId() {
        return feSessionId;
    }

    public void setFeSessionId(String feSessionId) {
        this.feSessionId = feSessionId;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentBal() {
        return currentBal;
    }

    public void setCurrentBal(String currentBal) {
        this.currentBal = currentBal;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEnableEncryption() {
        return enableEncryption;
    }

    public void setEnableEncryption(boolean enableEncryption) {
        this.enableEncryption = enableEncryption;
    }

    public String getEndChannel() {
        return endChannel;
    }

    public void setEndChannel(String endChannel) {
        this.endChannel = endChannel;
    }


}
