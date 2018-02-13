package com.apbl.promoterapp.screens.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.apbl.promoterapp.R;
import com.apbl.promoterapp.util.Util;
import com.apbl.promoterapp.view.uicamera.CameraSourcePreview;
import com.apbl.promoterapp.view.uicamera.FaceGraphic;
import com.apbl.promoterapp.view.uicamera.GraphicOverlay;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import static com.apbl.promoterapp.util.Util.setBadgeCount;

public class CameraActivity extends AppCompatActivity {

    private static final int RC_HANDLE_CAMERA_PERM = 2;
    int faceCount = 0;
    private CameraSource mCameraSource;
    private CameraSourcePreview mPreview;
    private GraphicOverlay mGraphicOverlay;
    private String SELFIE_PATH = Util.SELFIE_PATH + ".jpg";

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_camera);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.tool_bar_am);
        setToolbar(mToolbar);
        mPreview = (CameraSourcePreview) findViewById(R.id.preview);
        mGraphicOverlay = (GraphicOverlay) findViewById(R.id.faceOverlay);
        int rc = ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (rc == PackageManager.PERMISSION_GRANTED) {
            createCameraSource();
        } else {
            requestCameraPermission();
        }
        setButtonsEnabledState();
        findViewById(R.id.take_selfie).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPreview.takeImage();
            }
        });

        ImageView itemNotification = (ImageView) findViewById(R.id.notification_alert);
        itemNotification.setVisibility(View.VISIBLE);
        LayerDrawable icon = (LayerDrawable) itemNotification.getBackground();
        setBadgeCount(this, icon, "9");
    }
    public void setToolbar(Toolbar mToolbar) {
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
      TextView  mTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        mTitle.setText("Vijay Kumar");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setButtonsEnabledState() {
        if (faceCount == 1) {
            findViewById(R.id.take_selfie).setEnabled(true);

        } else {
            findViewById(R.id.take_selfie).setEnabled(false);
        }
    }


    private void requestCameraPermission() {
        final String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
            return;
        }

        final Activity thisActivity = this;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(thisActivity, permissions,
                        RC_HANDLE_CAMERA_PERM);
            }
        };

        Snackbar.make(mGraphicOverlay, R.string.permission_camera_rationale,
                Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.ok, listener)
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != RC_HANDLE_CAMERA_PERM) {

            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            createCameraSource();
            return;
        }

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Camera Permission")
                .setMessage(R.string.no_camera_permission)
                .setPositiveButton(R.string.ok, listener)
                .show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        startCameraSource();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mPreview.stop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCameraSource != null) {
            mCameraSource.release();
        }
    }


    private void createCameraSource() {

        Context context = getApplicationContext();
        FaceDetector detector = new FaceDetector.Builder(context)
                .setClassificationType(FaceDetector.NO_CLASSIFICATIONS)
                .setTrackingEnabled(true)
                .build();
        detector.setProcessor(
                new MultiProcessor.Builder<>(new GraphicFaceTrackerFactory()).build());


        if (!detector.isOperational()) {
            return;
        }

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mCameraSource = new CameraSource.Builder(context, detector)
                .setRequestedPreviewSize(metrics.heightPixels, metrics.widthPixels)
                .setFacing(CameraSource.CAMERA_FACING_FRONT)
                .setRequestedFps(25.0f)
                .build();
    }

    private void startCameraSource() {
        try {
            mPreview.start(mCameraSource, mGraphicOverlay);
        } catch (IOException e) {
            mCameraSource.release();
            mCameraSource = null;
        }
    }

    public void setImageViewPicture(final byte[] data) {

        Uri uriTarget = Uri.fromFile(new File(SELFIE_PATH));
        OutputStream imageFileOS;
        try {
            imageFileOS = getContentResolver().openOutputStream(uriTarget);
            imageFileOS.write(data);
            imageFileOS.flush();
            imageFileOS.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent returnIntent = new Intent();
        returnIntent.putExtra("URI", SELFIE_PATH);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }


    private class GraphicFaceTrackerFactory implements MultiProcessor.Factory<Face> {
        @Override
        public Tracker<Face> create(Face face) {
            return new GraphicFaceTracker(mGraphicOverlay);
        }
    }


    private class GraphicFaceTracker extends Tracker<Face> {
        private GraphicOverlay mOverlay;
        private FaceGraphic mFaceGraphic;

        GraphicFaceTracker(GraphicOverlay overlay) {
            mOverlay = overlay;
            mFaceGraphic = new FaceGraphic(overlay);
        }

        @Override
        public void onNewItem(int faceId, Face item) {

            ++faceCount;
            if (faceCount == 1) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.take_selfie).setEnabled(true);
                    }
                });
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.take_selfie).setEnabled(false);
                    }
                });
            }
        }

        @Override
        public void onUpdate(FaceDetector.Detections<Face> detectionResults, Face face) {
            mOverlay.add(mFaceGraphic);
            mFaceGraphic.updateFace(face);
        }

        @Override
        public void onMissing(FaceDetector.Detections<Face> detectionResults) {
            mOverlay.remove(mFaceGraphic);
        }

        @Override
        public void onDone() {
            --faceCount;
            if (faceCount == 1) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.take_selfie).setEnabled(true);
                    }
                });
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        findViewById(R.id.take_selfie).setEnabled(false);
                    }
                });
            }
            mOverlay.remove(mFaceGraphic);
        }
    }

}
