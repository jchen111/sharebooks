package com.sharebooks.config

import com.sharebooks.util.EmailTemplates.UserCreatedEmailTemplate
import com.sharebooks.util.handler.CommonResponseErrorHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClients

/**
 * Created by z001ktb on 3/18/16.
 */
@Configuration
@ComponentScan(basePackages = 'com.sharebooks')
@EnableConfigurationProperties(value = [MonogoDBProvider, MailgunProvider])
class ShareBooksConfig {

    @Autowired
    MailgunProvider properties


    @Bean
    MonogoDBCredentials monogoDBCredentials() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource()
        bundle.setBasename('mongodbCredentials')
        new MonogoDBCredentials(bundle)
    }

    @Bean
    MailgunCredentials mailgunCredentials() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource()
        bundle.setBasename('mailgunCredentials')
        new MailgunCredentials(bundle)
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(makeFactory(makeHttpClient()))
        restTemplate.setErrorHandler(responseErrorHandler())
        restTemplate
    }


    @Bean
    HttpComponentsClientHttpRequestFactory makeFactory(HttpClient httpClient){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient)
        factory.connectionRequestTimeout = properties.httpSettings.connectionRequestTimeoutMillis
        factory.connectTimeout = properties.httpSettings.connectionTimeoutMillis
        factory.readTimeout = properties.httpSettings.readTimeoutMillis
        factory
    }

    @Bean
    HttpClient makeHttpClient(){
        HttpClient httpClient = HttpClients.custom()
                .setMaxConnPerRoute(properties.httpSettings.maxRequestsPerRoute)
                .setMaxConnTotal(properties.httpSettings.maxRequestsTotal).build()
        httpClient
    }

    @Bean
    ResponseErrorHandler responseErrorHandler() {
        new CommonResponseErrorHandler()
    }
}
