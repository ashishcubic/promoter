package com.apbl.promoterapp.core.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.apbl.promoterapp.R;
import com.apbl.promoterapp.view.ProgressView;


public class DialogUtil {

    private static Dialog alertDialog;

    /***
     * To dismiss the dialog
     */
    public static void dismissLoadingDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
            alertDialog.cancel();
        }

    }

    /***
     * To show the dialog
     *
     * @param activity
     */
    public static void showLoadingDialog(Activity activity) {
        alertDialog = new Dialog((Context) activity);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.dialog_progress);
        ((ProgressView) alertDialog.findViewById(R.id.dotsProgressBar)).setDotsCount(4);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();
    }

    public static void showLoadingDialog(Context context) {
        alertDialog = new Dialog(context);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.dialog_progress);
        ((ProgressView) alertDialog.findViewById(R.id.dotsProgressBar)).setDotsCount(4);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        alertDialog.show();
    }
}
