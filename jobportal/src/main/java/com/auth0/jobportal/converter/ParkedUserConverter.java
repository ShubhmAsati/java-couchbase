package com.auth0.jobportal.converter;

import static java.lang.Boolean.FALSE;

import com.auth0.jobportal.entity.ParkedUserEntity;
import com.auth0.jobportal.model.ParkedUserDto;
import com.auth0.jobportal.model.request.RegistrationStepOneRequest;
import com.auth0.jobportal.model.response.RegistrationStepOneResponse;
import com.auth0.jobportal.util.Encipher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParkedUserConverter {

  private final Encipher encipher;

  public ParkedUserDto toParkedUserDto(RegistrationStepOneRequest registrationStepOneRequest) {
    return ParkedUserDto.builder()
        .mobileNumber(registrationStepOneRequest.getMobileNumber())
        .password(encipher.encrypt(registrationStepOneRequest.getPassword()))
        .firstName(registrationStepOneRequest.getFirstName())
        .lastName(registrationStepOneRequest.getLastName())
        .isVerified(FALSE)
        .build();
  }

  public ParkedUserEntity toParkedUserEntity(ParkedUserDto parkedUserDto) {
    return ParkedUserEntity.builder()
        .id(parkedUserDto.getTempUserId())
        .mobileNumber(parkedUserDto.getMobileNumber())
        .password(parkedUserDto.getPassword())
        .firstName(parkedUserDto.getFirstName())
        .lastName(parkedUserDto.getLastName())
        .isVerified(parkedUserDto.getIsVerified())
        .build();
  }

  public ParkedUserDto toParkedUserDto(ParkedUserEntity parkedUserEntity) {
    return ParkedUserDto.builder()
        .tempUserId(parkedUserEntity.getId())
        .mobileNumber(parkedUserEntity.getMobileNumber())
        .password(parkedUserEntity.getPassword())
        .isVerified(parkedUserEntity.getIsVerified())
        .firstName(parkedUserEntity.getFirstName())
        .lastName(parkedUserEntity.getLastName())
        .build();
  }

  public RegistrationStepOneResponse toResponse(ParkedUserDto parkedUserDto) {
    return RegistrationStepOneResponse.builder().userId(parkedUserDto.getTempUserId()).build();
  }
}
