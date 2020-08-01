package com.auth0.jobportal.converter;

import com.auth0.jobportal.model.StepTwoDto;
import com.auth0.jobportal.model.request.RegistrationStepTwoRequest;
import java.util.UUID;

public class StepTwoRequestConverter {

  private StepTwoRequestConverter(){}

  public static StepTwoDto toDto(RegistrationStepTwoRequest registrationStepTwoRequest){
    return StepTwoDto.builder()
        .userId(UUID.fromString(registrationStepTwoRequest.getUserId()))
        .otp(Integer.valueOf(registrationStepTwoRequest.getOtp()))
        .build();
  }

}
