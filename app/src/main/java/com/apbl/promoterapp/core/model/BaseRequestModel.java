package com.apbl.promoterapp.core.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sunny on 1/11/2018.
 */

public class BaseRequestModel {

    @SerializedName(value = "channel")
    private String channel;//PAPP

    @SerializedName(value = "feSessionId")
    private String feSessionId;

    @SerializedName(value = "langId")
    private String langId;

    @SerializedName(value = "ver")
    private String ver;


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

    public String getLangId() {
        return langId;
    }

    public void setLangId(String langId) {
        this.langId = langId;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }
}
