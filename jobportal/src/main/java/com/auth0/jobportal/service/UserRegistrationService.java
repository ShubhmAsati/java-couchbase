package com.auth0.jobportal.service;

import static com.auth0.jobportal.converter.UserConverter.toUserDto;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import com.auth0.jobportal.model.OTPDto;
import com.auth0.jobportal.model.ParkedUserDto;
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

  public ParkedUserDto registrationStepOne(ParkedUserDto parkedUserDto) {
    ParkedUserDto parkedUserDto1 = parkedUserRepository.saveParkedUser(parkedUserDto, TRUE);
    otpService
        .generateAndSendOTP(parkedUserDto1.getTempUserId(), parkedUserDto1.getMobileNumber(), TRUE);
    return parkedUserDto1;
  }


  public String verifyOTP(OTPDto otpDto) {
    otpService.validateOtp(otpDto);
    ParkedUserDto parkedUserDto = parkedUserRepository.getParkedUserById(otpDto.getUserId());
    parkedUserDto.setIsVerified(TRUE);
    parkedUserRepository.saveParkedUser(parkedUserDto, FALSE);
    return userRepository.saveUser(toUserDto(parkedUserDto)).getUserId().toString();
  }

  public void resendOTP(UUID userId, Boolean isNewOTPRequired) {
    ParkedUserDto parkedUserDto = parkedUserRepository.getParkedUserById(userId);
    otpService.resendOTP(parkedUserDto, isNewOTPRequired);


  }
}
