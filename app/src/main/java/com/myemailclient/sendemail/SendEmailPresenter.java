package com.myemailclient.sendemail;

import android.content.Context;
import android.util.Log;

import com.domain.DefaultObserver;
import com.domain.email.SendEmailRequest;
import com.domain.email.interactor.SendEmail;

import javax.inject.Inject;

/*
 * Created by dendy-prtha on 26/02/2019.
 * Send Email Presenter
 */
public class SendEmailPresenter implements SendEmailContract.Presenter {

    private String TAG = SendEmailPresenter.class.getSimpleName();
    private final Context context;
    private final SendEmailContract.View view;
    private final SendEmail sendEmail;

    @Inject
    public SendEmailPresenter(Context context, SendEmailContract.View view, SendEmail sendEmail) {
        this.context = context;
        this.view = view;
        this.sendEmail = sendEmail;
    }

    @Override
    public void sendEmail(String senderAddr, String senderPass,
                          String destinationAddr, String subject, String content) {
        Log.d(TAG, "test");
        sendEmail.execute(new DefaultObserver<Boolean>(){
            @Override
            public void onNext(Boolean isSucces)
            {
                Log.d(TAG, "isSucces : "+isSucces);
                view.onSendEmailSuccess();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError : "+ e.getClass().getName());
                view.onSendEmailFail();
            }
        }, new SendEmailRequest(senderAddr, senderPass,destinationAddr,subject, content));
    }

    @Override
    public void onDestroy() {

    }
}
