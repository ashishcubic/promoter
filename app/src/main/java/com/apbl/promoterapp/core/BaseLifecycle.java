package com.apbl.promoterapp.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

public interface BaseLifecycle {

    interface View {

        void openFragment(Fragment frag, Bundle bundle, String tag, int container);

        void openActivity(Intent intent);

        void openActivityForResult(Intent intent, int requestCode);
    }

    interface ViewModel {

        void onViewResumed();

        void onViewAttached(@NonNull View viewCallback);

        void onViewDetached();
    }
}


