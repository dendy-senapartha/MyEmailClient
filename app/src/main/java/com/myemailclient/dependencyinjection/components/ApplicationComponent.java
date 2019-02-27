package com.myemailclient.dependencyinjection.components;

import android.app.Application;
import android.content.Context;

import com.domain.PostExecutionThread;
import com.domain.ThreadExecutor;
import com.domain.email.repository.EmailRepository;
import com.myemailclient.application.MyEmailClientApplication;
import com.myemailclient.base.BaseActivity;
import com.myemailclient.dependencyinjection.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/*
 * Created by dendy-prtha on 26/02/2019.
 * DI Component for Application
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyEmailClientApplication myEmailClientApplication);

    void inject(BaseActivity baseActivity);

    Context context();

    Application application();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    EmailRepository provideEmailRepository();
}
