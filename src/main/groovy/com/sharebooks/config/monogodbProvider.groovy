package com.sharebooks.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by z001ktb on 3/18/16.
 */
@ConfigurationProperties(prefix = 'mongodbProvider', ignoreUnknownFields = true)
class MonogoDBProvider {

    //defaults
    static final String MONGODB_URL = '@ds037175.mlab.com:37175/sharebooksapplication'
    String mongodbUrl = MONGODB_URL
}
