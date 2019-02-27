package com.data.email;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * Created by dendy-prtha on 27/02/2019.
 * TODO: Add a class header comment!
 */

@StringDef({EmailSource.GMAIL})
@Retention(RetentionPolicy.SOURCE)
public @interface EmailSource {
    String GMAIL = "smtp.gmail.com";
}
