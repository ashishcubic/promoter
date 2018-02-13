package com.apbl.promoterapp.util;


public interface Constants {

    interface Login {

        interface Title {
            String LOGIN = "login";
            String LOGIN_MOBILE_NUM = "login mobile number";
            String LOGIN_CREATE_PWD = "login create password";
        }
    }

    interface ServiceMode {
        int VALIDATE_LAPU_NUMBER = 1;
        int LOGIN = 2;
        int SIGNUP = 3;
        int OTPVERIFY = 4;
        int RESETPASSWORD = 5;
        int REQUEST_IMAGE_CAPTURE=6;

    }

    interface APIS {
        String SIGNUP = "signUpPromoter";
        String OTPVERIFY = "otpVerify";
        String RESET_PASSWORD = "resetPassword";
        String LOGIN = "loginPromoter";
        String VALIDATE_LAPU_NUM = "validateLapuNumber";
    }

}
