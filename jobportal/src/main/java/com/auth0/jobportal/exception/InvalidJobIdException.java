package com.auth0.jobportal.exception;


import com.auth0.jobportal.constants.ApplicationConstants;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class InvalidJobIdException extends JobFinderBaseException{

    @Value(value = ApplicationConstants.ERR_MSG_INVALID_JOB_ID)
    static String message;

    public InvalidJobIdException(UUID id){
        super(message+id);
    }

}
