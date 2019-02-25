package com.example.myemailclient.mainactivity;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myemailclient.R;
import com.example.myemailclient.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/*
 * Created by dendy-prtha on 25/02/2019.
 * activity to sending email
 */
public class SendEmailActivity extends BaseActivity {

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

    String myEmailString, passString, sendToEmailString, subjectString, textString;
    SendEmailTask sendEmailTask;

    @Override
    public int getLayout() {
        return R.layout.activity_send_mail;
    }

    @Override
    public void init() {
        sendEmailTask = new SendEmailTask();
    }

    @OnClick(R.id.buttonSend)
    public void sendButton(View view) {
        myEmailString = senderEmail.getText().toString();
        passString = senderPassword.getText().toString();
        sendToEmailString = sendToEmail.getText().toString();
        subjectString = emailSubject.getText().toString();
        textString = emailBody.getText().toString();

        sendEmailTask.execute();
    }

    class SendEmailTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.i("Email sending", "sending start");
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                GmailSender sender = new GmailSender(myEmailString, passString);
                //subject, body, sender, to
                sender.sendMail(subjectString,
                        textString,
                        myEmailString,
                        sendToEmailString);

                Log.i("Email sending", "send");
            } catch (Exception e) {
                Log.i("Email sending", "cannot send");
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}
