package com.myemailclient.sendemail;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myemailclient.R;
import com.myemailclient.base.BaseActivity;
import com.myemailclient.dependencyinjection.components.DaggerSendEmailActivityComponent;
import com.myemailclient.dependencyinjection.components.SendEmailActivityComponent;
import com.myemailclient.dependencyinjection.modules.SendEmailActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * Created by dendy-prtha on 25/02/2019.
 * activity to sending email
 */
public class SendEmailActivity extends BaseActivity
        implements SendEmailContract.View {

    String TAG = SendEmailActivity.class.getSimpleName();

    @BindView(R.id.senderEmail)
    EditText senderEmail;
    @BindView(R.id.senderPassword)
    EditText senderPassword;
    @BindView(R.id.emailTo)
    EditText sendToEmail;
    @BindView(R.id.emailSubject)
    EditText emailSubject;
    @BindView(R.id.email_body)
    EditText emailBody;

    @BindView(R.id.buttonSend)
    Button sendButton;

    private SendEmailActivityComponent component;

    @Inject
    SendEmailPresenter presenter;

    String senderAddr, senderPass, destinationAddr, mailSubject, mailContent;
    //SendEmailTask sendEmailTask;

    @Override
    public int getLayout() {
        return R.layout.activity_send_mail;
    }

    @Override
    public void init() {
        initComponent();
        //sendEmailTask = new SendEmailTask();
    }

    private void initComponent() {
        if (component == null) {
            component = DaggerSendEmailActivityComponent.builder()
                    .applicationComponent(getApplicationComponent())
                    .sendEmailActivityModule(new SendEmailActivityModule(this))
                    .build();
        }
        component.inject(this);
        registerPresenter(presenter);
    }

    @OnClick(R.id.buttonSend)
    public void sendButton(View view) {
        senderAddr = senderEmail.getText().toString();
        senderPass = senderPassword.getText().toString();
        destinationAddr = sendToEmail.getText().toString();
        mailSubject = emailSubject.getText().toString();
        mailContent = emailBody.getText().toString();

        presenter.sendEmail(senderAddr, senderPass, destinationAddr, mailSubject, mailContent);
    }

    @Override
    public void onSendEmailFail() {

    }

    @Override
    public void onSendEmailSuccess() {

    }

}
