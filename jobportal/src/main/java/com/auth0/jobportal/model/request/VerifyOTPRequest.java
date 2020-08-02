package com.auth0.jobportal.model.request;

import com.auth0.jobportal.validator.UUID;
import com.auth0.jobportal.validator.UnsignedInteger;
import lombok.Data;

@Data
public class VerifyOTPRequest {

  @UUID
  private String userId;

  @UnsignedInteger
  private String otp;

}
