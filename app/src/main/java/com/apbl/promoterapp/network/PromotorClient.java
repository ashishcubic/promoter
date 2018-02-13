package com.apbl.promoterapp.network;

import com.apbl.promoterapp.model.requestmodels.VerifyLAPUModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PromotorClient<T> {


   /* @POST("verifyLapu")
    Observable<Response<JsonObject>> verifyLAPU(@Body VerifyLAPUModel tokenDTO);*/

    @POST("verifyLapu")
    Call<Object> verifyLAPUNew(@Body VerifyLAPUModel tokenDTO);

}
