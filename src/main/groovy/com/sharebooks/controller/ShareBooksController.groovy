package com.sharebooks.controller

import com.sharebooks.AppConstants
import com.sharebooks.domain.User
import com.sharebooks.dto.mapper.UserCreateRequestMapper
import com.sharebooks.dto.request.UserCreateRequest
import com.sharebooks.dto.response.UserCreateResponse
import com.sharebooks.service.ShareBooksService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

/**
 * Created by z001ktb on 3/17/16.
 */
@RestController
@RequestMapping(AppConstants.APP_CONTEXT_ROOT)
class ShareBooksController {

    @Autowired
    UserCreateRequestMapper userRequestMapper

    @Autowired
    ShareBooksService service

    @CrossOrigin
    @RequestMapping(value = AppConstants.APP_CONTEXT_USER_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
    @ResponseStatus(HttpStatus.CREATED)
    UserCreateResponse createUser(@Valid @RequestBody UserCreateRequest userCreateRequest){
        User user = userRequestMapper.toUser(userCreateRequest)
        service.createUser(user)
    }
}
