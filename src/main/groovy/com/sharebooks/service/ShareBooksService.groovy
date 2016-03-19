package com.sharebooks.service

import com.sharebooks.dao.MailgunDAO
import com.sharebooks.dao.UserDAO
import com.sharebooks.domain.User
import com.sharebooks.dto.response.UserCreateResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by z001ktb on 3/18/16.
 */
@Repository
class ShareBooksService {

    @Autowired
    UserDAO userDAO

    @Autowired
    MailgunDAO mailgunDAO

    UserCreateResponse createUser(User user) {
        UserCreateResponse userCreateResponse = userDAO.postUser(user)
        mailgunDAO.sendUserCreatedConfirmationEmail(user)
        userCreateResponse
    }
}
