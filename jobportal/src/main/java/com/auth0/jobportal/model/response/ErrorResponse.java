package com.auth0.jobportal.model.response;

import com.auth0.jobportal.model.ErrorDetails;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

@Builder
@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

  private LocalDateTime timeStamp;
  private List<ErrorDetails> errorDetails;

}
