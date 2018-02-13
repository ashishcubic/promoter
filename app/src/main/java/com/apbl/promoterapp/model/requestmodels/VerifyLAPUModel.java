package com.apbl.promoterapp.model.requestmodels;

import com.google.gson.annotations.SerializedName;



public class VerifyLAPUModel {

    @SerializedName(value = "ver")
    private String version;

    @SerializedName(value = "feSessionId")
    private String feSessionId;

    @SerializedName(value = "channel")
    private String channel;

    @SerializedName(value = "deviceId")
    private String deviceId;

    @SerializedName(value = "category")
    private String category;

    @SerializedName(value = "customerId")
    private String customerId;

    @SerializedName(value = "mode")
    private String mode;

    @SerializedName(value = "languageId")
    private String languageId;

    @SerializedName(value = "actorType")
    private String actorType;


    public VerifyLAPUModel(String version, String feSessionId, String channel, String deviceId, String category, String customerId, String mode, String languageId, String actorType) {
        this.version = version;
        this.feSessionId = feSessionId;
        this.channel = channel;
        this.deviceId = deviceId;
        this.category = category;
        this.customerId = customerId;
        this.mode = mode;
        this.languageId = languageId;
        this.actorType = actorType;
    }


    public VerifyLAPUModel() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFeSessionId() {
        return feSessionId;
    }

    public void setFeSessionId(String feSessionId) {
        this.feSessionId = feSessionId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }
}
