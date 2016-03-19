package com.sharebooks.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.sharebooks.dto.DTOConstants

import javax.validation.constraints.NotNull

/**
 * Created by z001ktb on 3/18/16.
 */
class UserCreateRequest {

    @JsonProperty(DTOConstants.FIRST_NAME)
    @NotNull
    String firstName

    @JsonProperty(DTOConstants.LAST_NAME)
    @NotNull
    String lastName

    @JsonProperty(DTOConstants.NICK_NAME)
    @NotNull
    String nickName

    @JsonProperty(DTOConstants.EMAIL)
    @NotNull
    String email

    @JsonProperty(DTOConstants.PASSWORD)
    @NotNull
    String password
}
