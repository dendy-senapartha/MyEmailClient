package com.domain.email;

/*
 * Created by dendy-prtha on 27/02/2019.
 * Request for sending email
 */
public class SendEmailRequest {
    public String senderAddr;
    public String senderPass;
    public String destinationAddr;
    public String mailSubject;
    public String mailContent;

    public SendEmailRequest(String senderAddr, String senderPass, String destinationAddr,
                            String mailSubject, String mailContent)
    {
        this.senderAddr = senderAddr;
        this.senderPass = senderPass;
        this.destinationAddr = destinationAddr;
        this.mailSubject = mailSubject;
        this.mailContent = mailContent;
    }
}
