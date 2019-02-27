package com.data.email.repository.source;

import javax.inject.Inject;
import javax.inject.Singleton;

/*
 * Created by dendy-prtha on 27/02/2019.
 * TODO: Add a class header comment!
 */


public class EmailFactory {

    @Inject
    public EmailFactory()
    {

    }

    public Gmail createGmailSender()
    {
        return new Gmail();
    }
}
