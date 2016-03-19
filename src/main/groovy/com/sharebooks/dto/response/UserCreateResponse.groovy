package com.sharebooks.dto.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.sharebooks.dto.DTOConstants
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by z001ktb on 3/18/16.
 */
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
class UserCreateResponse {

    @JsonProperty(DTOConstants.FIRST_NAME)
    String firstName

    @JsonProperty(DTOConstants.LAST_NAME)
    String lastName

    @JsonProperty(DTOConstants.EMAIL)
    String email

    @JsonProperty(DTOConstants.NICK_NAME)
    String nickName

//    @JsonSerialize(using=LocalDateTimeSerializer)
    @JsonProperty(DTOConstants.TIMESTAMP)
    String timestamp
}
