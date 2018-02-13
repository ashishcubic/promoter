package com.apbl.promoterapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.apbl.promoterapp.util.Util;


@SuppressLint("AppCompatCustomView")
public class MyCustomTextView extends TextView {
    public MyCustomTextView(Context context) {
        super(context);
        Util.getInstance().initTypefaceView(this, context, null);
    }

    public MyCustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Util.getInstance().initTypefaceView(this, context, attrs);
    }

    public MyCustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Util.getInstance().initTypefaceView(this, context, attrs);
    }
}
