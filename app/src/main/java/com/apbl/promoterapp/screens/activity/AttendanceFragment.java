package com.apbl.promoterapp.screens.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.apbl.promoterapp.R;
import com.apbl.promoterapp.core.BaseActivity;
import com.apbl.promoterapp.core.BaseFragment;
import com.apbl.promoterapp.core.BaseLifecycle;
import java.io.File;
import de.hdodenhof.circleimageview.CircleImageView;

public class AttendanceFragment extends BaseFragment implements View.OnClickListener {

    private CircleImageView mSelfieView;
    private BaseLifecycle.ViewModel viewModel;
    private View mView;
    private String userType = "";

    @Override
    protected BaseLifecycle.ViewModel getViewModel() {
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attendance, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.mView = view;
        init();


    }

    private void init() {
        TextView mTitle = (TextView) mView.findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Vijay Kumar");
        mSelfieView = (CircleImageView) mView.findViewById(R.id.selfie_image);
        mView.findViewById(R.id.btn_attendance_submit).setOnClickListener(this);
        mSelfieView.setOnClickListener(this);
    }


    public static Bitmap getBitmapFromURL(String src) {
        File imgFile = new File(src);
        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            return myBitmap;
        }
        return null;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.selfie_image:
                ((BaseActivity) getContext()).openActivityForResult(new Intent(getActivity(),CameraActivity.class),10);
                break;
            case R.id.btn_attendance_submit:
                break;

            default:
                break;
        }
    }


   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.ServiceMode.REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            mSelfieView.setImageBitmap(getBitmapFromURL(extras.getString("URI")));
        }

    }*/
}
