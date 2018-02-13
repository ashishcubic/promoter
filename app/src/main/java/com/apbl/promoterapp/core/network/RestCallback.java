package com.apbl.promoterapp.core.network;

import retrofit2.Response;

public interface RestCallback<T> {

    void onApiFailure(Throwable e, int serviceMode);

    void onApiSuccess(Response<T> response, int serviceMode);

}