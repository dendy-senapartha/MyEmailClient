package com.data.email.repository;

import com.data.email.repository.source.EmailFactory;
import com.data.email.repository.source.Gmail;
import com.domain.email.SendEmailRequest;
import com.domain.email.repository.EmailRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/*
 * Created by dendy-prtha on 27/02/2019.
 * implementation of Email repository from domain
 */

@Singleton
public class EmailDataRepository implements EmailRepository {

    private final EmailFactory emailFactory;

    @Inject
    public EmailDataRepository(EmailFactory emailFactory) {
        this.emailFactory = emailFactory;
    }

    /*Instructs an ObservableSource to pass control to another ObservableSource rather than invoking onError if it encounters an error.
     * */
    protected <T> Observable<T> initializedRequest(Observable<T> observable) {
        return observable.onErrorResumeNext(observable);
    }

    @Override
    public Observable<Boolean> SendEmail(SendEmailRequest request) {
        Gmail gmail = emailFactory.createGmailSender();
        gmail.setUser(request.senderAddr);
        gmail.setPassword(request.senderPass);

        return Observable.create(
                emitter -> {
                    gmail.sendMail(emitter, request.mailSubject, request.mailContent, request.senderAddr, request.destinationAddr);
                }
        );
    }
}
