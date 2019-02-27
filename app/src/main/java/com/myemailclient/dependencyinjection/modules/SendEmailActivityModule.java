package com.myemailclient.dependencyinjection.modules;

import com.myemailclient.dependencyinjection.PerActivity;
import com.myemailclient.sendemail.SendEmailContract;
import com.myemailclient.sendemail.SendEmailPresenter;

import dagger.Module;
import dagger.Provides;

/*
 * Created by dendy-prtha on 26/02/2019.
 * DI component sendEmailActivity module
 */
@Module
public class SendEmailActivityModule {

    private SendEmailContract.View view ;

    public SendEmailActivityModule(SendEmailContract.View view)
    {
        this.view = view;
    }

    @Provides
    @PerActivity
    SendEmailContract.View provideView()
    {
        return view;
    }

    @Provides
    @PerActivity
    SendEmailContract.Presenter providePresenter(SendEmailPresenter presenter)
    {
        return presenter;
    }

}
