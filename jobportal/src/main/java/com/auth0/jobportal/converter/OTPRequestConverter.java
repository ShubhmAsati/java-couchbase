package com.auth0.jobportal.converter;

import com.auth0.jobportal.model.OTPDto;
import com.auth0.jobportal.model.request.VerifyOTPRequest;
import java.util.UUID;

public class OTPRequestConverter {

  private OTPRequestConverter() {
  }

  public static OTPDto toDto(VerifyOTPRequest verifyOTPRequest) {
    return OTPDto.builder()
        .userId(UUID.fromString(verifyOTPRequest.getUserId()))
        .otp(Integer.valueOf(verifyOTPRequest.getOtp()))
        .build();
  }

}
