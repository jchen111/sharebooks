package com.sharebooks.dto.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.sharebooks.dto.DTOConstants
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by z001ktb on 3/19/16.
 */
@ToString
@EqualsAndHashCode
class EmailSentResponse {
    @JsonProperty(  DTOConstants.ID)
    String id

    @JsonProperty(DTOConstants.MESSAGE)
    String message
}
