package com.apbl.promoterapp.model.requestmodels;

import com.apbl.promoterapp.core.model.BaseRequestModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by a1nc1l1v on 1/25/2018.
 */

public class ValidateTokenRequestModel extends BaseRequestModel {


    @SerializedName(value = "retailerId")
    private String retailerId;

    @SerializedName(value = "category")
    private String category;

    public String getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
