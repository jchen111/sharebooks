package com.sharebooks.config

import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ReloadableResourceBundleMessageSource

/**
 * Created by z001ktb on 3/18/16.
 */
class MonogoDBCredentials {
    String mongodbUsername
    String mongodbPassword

    MonogoDBCredentials(ReloadableResourceBundleMessageSource bundle) {
        Locale currentLocale = LocaleContextHolder.locale
        mongodbUsername = bundle.getMessage('mongodb.username', null, currentLocale)
        mongodbPassword = bundle.getMessage('mongodb.password', null, currentLocale)
    }

    MonogoDBCredentials(String username, String password){
        mongodbUsername = username
        mongodbPassword = password
    }
}
