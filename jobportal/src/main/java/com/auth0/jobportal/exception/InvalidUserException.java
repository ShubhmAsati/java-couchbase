package com.auth0.jobportal.exception;

import com.auth0.jobportal.constants.ApplicationConstants;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

public class InvalidUserException extends JobFinderBaseException{
    @Value(value = ApplicationConstants.ERR_MSG_INVALID_JOB_REVIEWS_CREATION)
    static String message;

    public InvalidUserException(){
        super(message);
    }
}
