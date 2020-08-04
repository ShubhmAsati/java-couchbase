package com.auth0.jobportal.model.request;

import com.auth0.jobportal.validator.UUID;
import lombok.Data;

@Data
public class ResendOtpRequest {

  @UUID
  private String userId;

}
