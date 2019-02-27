package com.myemailclient.dependencyinjection.components;

import com.myemailclient.dependencyinjection.PerActivity;
import com.myemailclient.dependencyinjection.modules.SendEmailActivityModule;
import com.myemailclient.sendemail.SendEmailActivity;

import dagger.Component;

/*
 * Created by dendy-prtha on 26/02/2019.
 * DI component for SendEmailActivity
 */

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {SendEmailActivityModule.class})
public interface SendEmailActivityComponent {
    void inject(SendEmailActivity activity);
}
