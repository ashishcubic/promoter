package com.apbl.promoterapp.core.network;

import android.content.Context;

import com.apbl.promoterapp.core.util.DialogUtil;


public class RestProcess<T> {

    private final RestCallback restCallback;
    private final int serviceMode;
    private Context mContext;


    /**
     * Description : Used to handle success and failure of RESTApi
     *
     * @param restCallback
     * @param serviceMode  : Integer to get along with result after response
     */
    public RestProcess(Context context, RestCallback restCallback, int serviceMode, boolean isProgressDialogShow) {
        this.restCallback = restCallback;
        this.serviceMode = serviceMode;
        this.mContext = context;
        if (isProgressDialogShow) {
            DialogUtil.showLoadingDialog(mContext);
        }

    }

   /* public void makeApiRequest(Observable<Response<T>> observable) {

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<T>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<T> response) {
                        DialogUtil.dismissLoadingDialog();
                        System.out.println("Data--->" + "onNext onNext");
                        if (restCallback != null) {
                            restCallback.onApiSuccess(response, serviceMode);
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        DialogUtil.dismissLoadingDialog();
                        if (restCallback != null) {
                            restCallback.onApiFailure(e, serviceMode);
                        }

                        System.out.println("Data--->" + "onError onError");

                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Data--->" + "onComplete onComplete");

                    }
                });

    }*/

}
