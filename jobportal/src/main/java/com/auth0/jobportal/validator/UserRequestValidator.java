package com.auth0.jobportal.validator;

import static com.auth0.jobportal.constants.ApplicationConstants.ERR_MSG_INVALID_UUID;
import static java.util.Collections.singletonList;
import static java.util.UUID.fromString;

import com.auth0.jobportal.exception.ValidationsException;
import com.auth0.jobportal.model.ErrorDetails;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class UserRequestValidator {

  public UUID validateAndReturnUserId(String userId) {
    try {
      return fromString(userId);
    } catch (IllegalArgumentException e) {
      throw new ValidationsException(buildErrorDetails(ERR_MSG_INVALID_UUID));
    }
  }

  private List<ErrorDetails> buildErrorDetails(String message) {
    return singletonList(ErrorDetails.builder()
        .message(message)
        .build());
  }

}
