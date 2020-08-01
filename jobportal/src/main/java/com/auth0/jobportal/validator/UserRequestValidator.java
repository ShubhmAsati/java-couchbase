package com.auth0.jobportal.validator;

import static com.auth0.jobportal.constants.ApplicationConstants.ERR_MSG_INVALID_UUID;
import static java.util.UUID.fromString;

import com.auth0.jobportal.exception.ValidationsException;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserRequestValidator {

  public UUID validateAndReturnUserId(String userId) {
    try {
      return fromString(userId);
    } catch (IllegalArgumentException e) {
      throw new ValidationsException(ERR_MSG_INVALID_UUID);
    }
  }

}
