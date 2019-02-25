package com.example.myemailclient.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/*
 * Created by dendy-prtha on 25/02/2019.
 * application class
 */
public class MyEmailClientApplication extends MultiDexApplication {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        initializeContext();
        registerActivityLifecycleCallbacks(new ActivityLifecycleBehavior());
    }

    private void initializeContext() {
        MyEmailClientApplication.context = getApplicationContext();
    }
}
