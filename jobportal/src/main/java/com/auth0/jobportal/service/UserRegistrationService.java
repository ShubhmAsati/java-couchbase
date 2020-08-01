package com.auth0.jobportal.service;

import static com.auth0.jobportal.converter.UserConverter.toUserDto;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import com.auth0.jobportal.converter.UserConverter;
import com.auth0.jobportal.model.ParkedUserDto;
import com.auth0.jobportal.model.StepTwoDto;
import com.auth0.jobportal.repository.ParkedUserRepository;
import com.auth0.jobportal.repository.UserRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

  private final ParkedUserRepository parkedUserRepository;
  private final UserRepository userRepository;
  private final OTPService otpService;

  public ParkedUserDto registrationStepOne(ParkedUserDto parkedUserDto){
    ParkedUserDto parkedUserDto1 = parkedUserRepository.saveParkedUser(parkedUserDto);
    otpService.generateAndSendOTP(parkedUserDto1.getTempUserId(), parkedUserDto1.getMobileNumber(), TRUE);
    return parkedUserDto1;
  }


  public String registrationStepTwo(StepTwoDto stepTwoDto) {
    otpService.validateOtp(stepTwoDto);
    ParkedUserDto parkedUserDto = parkedUserRepository.getParkedUserById(stepTwoDto.getUserId());
    parkedUserDto.setIsVerified(TRUE);
    parkedUserRepository.saveParkedUser(parkedUserDto);
    return userRepository.saveUser(toUserDto(parkedUserDto)).getUserId().toString();
  }

  public void resendOTP(UUID userId, Boolean isNewOTPRequired) {
    if(isNewOTPRequired) {
      otpService.resendOTP(userId);
    } else {
      ParkedUserDto parkedUserDto = parkedUserRepository.getParkedUserById(userId);
      otpService.generateAndSendOTP(parkedUserDto.getTempUserId(), parkedUserDto.getMobileNumber(), FALSE);
    }

  }
}
