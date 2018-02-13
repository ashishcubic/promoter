package com.apbl.promoterapp.network;

import com.apbl.promoterapp.model.requestmodels.VerifyLAPUModel;
import com.apbl.promoterapp.model.responsemodels.VerifuLAPUResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by  on 13/2/18.
 */

public interface APIService {

    @POST("verifyLapu")
    Call<VerifuLAPUResponse> verifyLAPUNew(@Body VerifyLAPUModel tokenDTO);

}
