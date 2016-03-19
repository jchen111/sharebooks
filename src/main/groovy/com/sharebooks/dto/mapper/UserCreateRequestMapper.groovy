package com.sharebooks.dto.mapper

import com.sharebooks.domain.User
import com.sharebooks.dto.request.UserCreateRequest
import org.springframework.stereotype.Component

/**
 * Created by z001ktb on 3/18/16.
 */
@Component
class UserCreateRequestMapper {
    User toUser(UserCreateRequest request){
        new User(request.firstName, request.lastName, request.nickName, request.email, request.password)
    }
}
