package com.apbl.promoterapp.network;

/**
 * Created by  on 13/2/18.
 */

public class ApiUtils {

    private ApiUtils() {}

    private static final String BASE_URL = "http://promoterapp.ap-south-1.elasticbeanstalk.com/api/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
