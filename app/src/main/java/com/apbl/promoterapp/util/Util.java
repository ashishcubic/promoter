package com.apbl.promoterapp.util;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Environment;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.apbl.promoterapp.R;

import java.io.File;

public class Util {
    public static String SELFIE_PATH = Environment.getExternalStorageDirectory() + "/Selfie/";
    private static Util ourInstance = null;

    private Util() {
    }

    public static Util getInstance() {

        if (ourInstance == null)
            ourInstance = new Util();
        return ourInstance;
    }

    public static boolean isValidString(String text) {
        return (text != null && !text.isEmpty());
    }

    public static void cleanFolder() {

        String datapath = SELFIE_PATH;
        File selfiePath = new File(datapath);
        if (!selfiePath.exists()) {
            if (!selfiePath.mkdir()) {

            }
        } else {
           /* for (File child : tenpPath.listFiles()) {
                // Keep only config files
                if (!child.getName().contains(".txt")) {
                    child.delete();
                }
            }*/
        }
    }

    public boolean isPasswordMatch(TextInputLayout pwdLayout, TextInputLayout confirmPwdLayout, String errorMsg) {
        String pwd = pwdLayout.getEditText().getText().toString().trim();
        String confirmPwd = confirmPwdLayout.getEditText().getText().toString().trim();
        if (!pwd.equals(confirmPwd)) {
            setInputLayoutError(pwdLayout, errorMsg);
            return false;
        }
        return true;
    }

    public boolean isValidInputTextField(TextInputLayout layout, String emptyErrMsg) {
        String text = layout.getEditText().getText().toString().trim();

        if (!isValidString(text)) {
            setInputLayoutError(layout, emptyErrMsg);
            return false;
        }

        return true;
    }

    public void setInputLayoutError(final TextInputLayout layout, String errMsg) {
        layout.setErrorEnabled(true);
        layout.setError(errMsg);
        layout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                layout.setError("");
                layout.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void initTypefaceView(View view, Context context, AttributeSet attrs) {
        if (view.isInEditMode()) {
            return;
        }

        int textStyle = 0;

        if (attrs != null) {
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.MyCustomTextView);
            textStyle = styledAttrs.getInt(R.styleable.MyCustomTextView_textStyle, 0);
            styledAttrs.recycle();
        }
        switch (textStyle) {
            case 0:
                ((TextView) view).setTypeface(getTondoRegularTypeFace(context));
                break;
            case 1:
                ((TextView) view).setTypeface(getTondoBoldTypeFace(context));
                break;
            case 2:
                ((TextView) view).setTypeface(getTondoLightTypeFace(context));
                break;
            case 3:
                ((TextView) view).setTypeface(getTondoSignTypeFace(context));
                break;

            default:
                ((TextView) view).setTypeface(getTondoRegularTypeFace(context));
                break;
        }
    }

    public Typeface getTondoRegularTypeFace(Context context) {
        try {
            return Typeface.createFromAsset(context.getAssets(), "tondo_corp_rg.ttf");
        } catch (Exception ex) {

        }
        return null;
    }

    public Typeface getTondoBoldTypeFace(Context context) {
        try {
            return Typeface.createFromAsset(context.getAssets(), "tondo_corp_bd.ttf");
        } catch (Exception ex) {

        }
        return null;
    }

    public Typeface getTondoLightTypeFace(Context context) {
        try {
            return Typeface.createFromAsset(context.getAssets(), "tondo_corp_lt.ttf");
        } catch (Exception ex) {

        }
        return null;
    }

    public Typeface getTondoSignTypeFace(Context context) {
        try {
            return Typeface.createFromAsset(context.getAssets(), "tondo_corp_sign.ttf");
        } catch (Exception ex) {

        }
        return null;
    }

    public void showToast(Context context, String msg) {
        if (msg != null)
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BadgeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }
}
