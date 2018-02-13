package com.apbl.promoterapp.screens;

import com.apbl.promoterapp.core.BaseLifecycle;
import com.apbl.promoterapp.model.requestmodels.VerifyLAPUModel;

public interface LoginContract {

    interface View extends BaseLifecycle.View{
        void onSuccess(int serviceMode);

        void onFailure(int serviceMode, String msg);

    }
    interface ViewModel extends BaseLifecycle.ViewModel{
        void login(int serviceMode);
        void verifyLAPU(VerifyLAPUModel verifyLAPUModel);

    }
}
