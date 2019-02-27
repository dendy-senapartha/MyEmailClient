package com.myemailclient.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.myemailclient.dependencyinjection.components.ApplicationComponent;
import com.myemailclient.dependencyinjection.components.DaggerApplicationComponent;
import com.myemailclient.dependencyinjection.modules.ApplicationModule;

/*
 * Created by dendy-prtha on 25/02/2019.
 * application class
 */
public class MyEmailClientApplication extends MultiDexApplication {

    private static Context context;

    private ApplicationComponent applicationComponent;

    public void onCreate() {
        super.onCreate();
        initializeContext();
        initInjector();
        registerActivityLifecycleCallbacks(new ActivityLifecycleBehavior());
    }

    private void initInjector()
    {
        if(applicationComponent == null)
        {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
    }

    private void initializeContext() {
        MyEmailClientApplication.context = getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent()
    {
        return  applicationComponent;
    }
}
