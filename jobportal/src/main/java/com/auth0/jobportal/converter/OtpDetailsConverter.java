package com.auth0.jobportal.converter;

import com.auth0.jobportal.entity.OtpManagerEntity;
import com.auth0.jobportal.model.OtpDetailsDto;

public class OtpDetailsConverter {

  private OtpDetailsConverter() {
  }

  public static OtpDetailsDto toOtpDetailsDto(OtpManagerEntity otpManagerEntity) {
    return OtpDetailsDto.builder()
        .lastUpdatedAt(otpManagerEntity.getUpdatedAt())
        .otp(otpManagerEntity.getOtp())
        .userId(otpManagerEntity.getUserId())
        .build();
  }

  public static OtpManagerEntity toEntity(OtpDetailsDto otpDetailsDto){
    return OtpManagerEntity.builder()
        .resendCount(otpDetailsDto.getResendCount()!=null? otpDetailsDto.getResendCount():0)
        .userId(otpDetailsDto.getUserId())
        .otp(otpDetailsDto.getOtp())
        .build();
  }

}
