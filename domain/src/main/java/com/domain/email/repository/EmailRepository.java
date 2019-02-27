package com.domain.email.repository;

import com.domain.email.SendEmailRequest;

import io.reactivex.Observable;

/*
 * Created by dendy-prtha on 27/02/2019.
 * Email repository
 */
public interface EmailRepository {
    Observable<Boolean> SendEmail(SendEmailRequest request);
}
