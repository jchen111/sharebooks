package com.sharebooks.dto.mapper

import com.sharebooks.domain.User
import com.sharebooks.dto.response.UserCreateResponse
import org.springframework.stereotype.Component

import java.time.LocalDateTime

/**
 * Created by z001ktb on 3/18/16.
 */
@Component
class UserCreateResponseMapper {

    UserCreateResponse toUserCreateResponse(User user, LocalDateTime timestamp) {
        new UserCreateResponse(
                firstName: user.firstName,
                lastName: user.lastName,
                nickName: user.nickName,
                email: user.email,
                timestamp: timestamp.toString()
        )
    }
}
