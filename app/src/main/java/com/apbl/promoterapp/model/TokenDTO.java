package com.apbl.promoterapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * DTO class to make JSON for Generating JWT Token Request
 * (We are not calling it for our own at moment)
 * Created by Sunny on 3/3/2016.
 */
public class TokenDTO {

    @SerializedName(value = "ver")
    private String ver;

    @SerializedName(value = "feSessionId")
    private String feSessionId;

    @SerializedName(value = "actorId")
    private String retailerId;

    @SerializedName(value = "jwtExpiry")
    private String jwtExpiry;

    @SerializedName(value = "languageId")
    private String languageId;

    @SerializedName(value = "channel")
    private String channel;

    @SerializedName(value = "mobilityToken")
    private String mobilityToken;

    @SerializedName(value = "retailerMsisdn")
    private String retailerMsisdn;

    @SerializedName(value = "endChannel")
    private String endChannel;

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

    @SerializedName(value = "actorType")
    private String actorType;

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getFeSessionId() {
        return feSessionId;
    }

    public void setFeSessionId(String feSessionId) {
        this.feSessionId = feSessionId;
    }

    public String getJwtExpiry() {
        return jwtExpiry;
    }

    public void setJwtExpiry(String jwtExpiry) {
        this.jwtExpiry = jwtExpiry;
    }

    public String getMobilityToken() {
        return mobilityToken;
    }

    public void setMobilityToken(String mobilityToken) {
        this.mobilityToken = mobilityToken;
    }

    public String getRetailerMsisdn() {
        return retailerMsisdn;
    }

    public void setRetailerMsisdn(String retailerMsisdn) {
        this.retailerMsisdn = retailerMsisdn;
    }

    public String getEndChannel() {
        return endChannel;
    }

    public void setEndChannel(String endChannel) {
        this.endChannel = endChannel;
    }
}
