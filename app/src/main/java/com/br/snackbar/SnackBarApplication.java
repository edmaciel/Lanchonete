package com.br.snackbar;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

public class SnackBarApplication extends Application {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        //snackComponent = DaggerSnackBarComponent.builder().build();
//        DaggerSnackBarComponent.builder()
//                .application(this)
//                .build().inject(this);
    }

//    @Override
//    public AndroidInjector<Activity> activityInjector() {
//        return dispatchingActivityInjector;
//    }
}
