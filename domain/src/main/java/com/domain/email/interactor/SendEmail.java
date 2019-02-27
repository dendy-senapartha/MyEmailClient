package com.domain.email.interactor;

import com.domain.PostExecutionThread;
import com.domain.ThreadExecutor;
import com.domain.UseCase;
import com.domain.email.SendEmailRequest;
import com.domain.email.repository.EmailRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/*
 * Created by dendy-prtha on 27/02/2019.
 * Usecase for sending email
 */
public class SendEmail extends UseCase<Boolean, SendEmailRequest> {

    private final EmailRepository emailRepository;

    @Inject
    public SendEmail(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread
            ,EmailRepository emailRepository) {
        super(threadExecutor, postExecutionThread);
        this.emailRepository = emailRepository;
    }

    @Override
    protected Observable<Boolean> buildUseCaseObservable(SendEmailRequest request) {
        return emailRepository.SendEmail(request);
    }
}
