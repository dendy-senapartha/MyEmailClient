package com.myemailclient.sendemail;

import com.myemailclient.base.BaseContract;

/*
 * Created by dendy-prtha on 26/02/2019.
 * Contract for SendEmail in MVP arch
 */
public interface SendEmailContract {
    interface View {
        void onSendEmailFail();

        void onSendEmailSuccess();
    }

    interface Presenter extends BaseContract.BasePresenterContract {
        void sendEmail(String senderAddr, String senderPass,
                       String destinationAddr, String subject, String content);
    }

}
