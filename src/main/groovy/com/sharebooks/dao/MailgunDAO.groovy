package com.sharebooks.dao

import com.sharebooks.config.MailgunCredentials
import com.sharebooks.config.MailgunProvider
import com.sharebooks.domain.User
import com.sharebooks.dto.response.EmailSentResponse
import com.sharebooks.util.EmailTemplates.UserCreatedEmailTemplate
import com.sharebooks.util.exceptions.InternalErrorException
import com.sun.jersey.core.util.MultivaluedMapImpl
import org.apache.commons.codec.binary.Base64
import org.apache.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

/**
 * Created by z001ktb on 3/19/16.
 */
@Repository
@Component(value = 'MailgunDAO')
class MailgunDAO {

    @Autowired
    RestTemplate restTemplate

    @Autowired
    MailgunCredentials mailgunCredentials

    @Autowired
    MailgunProvider mailgunProvider

    UserCreatedEmailTemplate userCreatedEmailTemplate

    File htmlTemplate = new File('src/main/resources/emailTemplate.html')

    HttpHeaders creatAuthenticationHeader() {
        String plainCreds = 'api' + ':' + mailgunCredentials.mailgunApiKey;
        byte[] plainCredsBytes = plainCreds.getBytes()
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes)
        String base64Creds = new String(base64CredsBytes)

        HttpHeaders headers = new HttpHeaders()
        headers.add('Authorization', 'Basic ' + base64Creds)
        headers
    }

    void sendUserCreatedConfirmationEmail(User user) {
        synchronized (htmlTemplate) {
            userCreatedEmailTemplate = new UserCreatedEmailTemplate(htmlTemplate)
            userCreatedEmailTemplate.body(user.nickName,'created', 'www.google.com')
        }

        MultiValueMap formData = new LinkedMultiValueMap<String, String>()
        formData.add("from", DAOConstants.SYSTEM_ADMIN+" "+DAOConstants.SYSTEM_ADMIN_NAME+"@"+mailgunProvider.mailgunDomain)
        formData.add("to", user.email)
        formData.add("subject", "Welcome to join ShareBooks")
        formData.add("html", htmlTemplate.getText('UTF-8'))

        HttpEntity<MultiValueMap> request = new HttpEntity<MultiValueMap>(formData,creatAuthenticationHeader())
        ResponseEntity<EmailSentResponse> response = restTemplate.exchange(mailgunProvider.mailgunBaseUrl+mailgunProvider.mailgunDomain+"/messages",
                HttpMethod.POST, request, EmailSentResponse)
        if(response.statusCode.value() != 200){
            throw new InternalErrorException('Email can not be delivered due to Internal Server Error.')
        }
    }
}
