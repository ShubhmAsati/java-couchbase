package com.auth0.jobportal.exception;

import com.auth0.jobportal.model.ErrorDetails;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidOTPException extends RuntimeException {

  private List<ErrorDetails> errorDetails;

}
