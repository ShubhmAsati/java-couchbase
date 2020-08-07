package com.auth0.jobportal.service;

import static com.auth0.jobportal.constants.ApplicationConstants.ERR_MSG_INVALID_OTP;
import static com.auth0.jobportal.constants.ApplicationConstants.ERR_MSG_INVALID_PASSWORD;
import static com.auth0.jobportal.enums.OtpType.LOGIN;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.UUID.fromString;

import com.auth0.jobportal.exception.InvalidOTPException;
import com.auth0.jobportal.exception.ValidationsException;
import com.auth0.jobportal.model.OTPDto;
import com.auth0.jobportal.model.OtpDetailsDto;
import com.auth0.jobportal.model.UserDto;
import com.auth0.jobportal.repository.UserRepository;
import com.auth0.jobportal.util.Encipher;
import com.auth0.jobportal.util.JwtUtil;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

  private final UserRepository userRepository;
  private final OTPService otpService;
  private final Encipher encipher;
  private final JwtUtil jwtUtil;

  public UUID login(String mobileNumber, Boolean isLoginOTP) {
    UserDto userDto = userRepository.findUserByMobileNumber(mobileNumber);
    OtpDetailsDto otpDetailsDto = otpService
        .generateAndSendOTP(userDto.getUserId(), userDto.getMobileNumber(), LOGIN);
    otpDetailsDto.setIsLoginOTP(FALSE);
    if (isLoginOTP) {
      otpDetailsDto.setIsLoginOTP(TRUE);
    }
    otpService.updateOtpType(otpDetailsDto);
    return userDto.getUserId();
  }

  public UUID loginByPassword(String mobileNumber, String password) {
    UserDto userDto = userRepository.findUserByMobileNumber(mobileNumber);
    if (encipher.matches(password, userDto.getPassword())) {
      return userDto.getUserId();
    }
    throw new ValidationsException(ERR_MSG_INVALID_PASSWORD);
  }

  public UUID verifyOTP(OTPDto otpDto, Boolean isLoginOTP) {
    OtpDetailsDto otpDetailsDto = otpService.validateOtp(otpDto, LOGIN);
    if (isLoginOTP ^ otpDetailsDto.getIsLoginOTP()) {
      throw new InvalidOTPException(ERR_MSG_INVALID_OTP);
    }
    return userRepository.findUserById(otpDto.getUserId()).getUserId();
  }

  public void resetPassword(String password, String token) {
    UUID userId = fromString(jwtUtil.extractUserId(token));
    UserDto userDto = userRepository.findUserById(userId);
    userDto.setPassword(encipher.encrypt(password));
    userRepository.saveUser(userDto);
  }

  public UUID resendOTP(String userId, Boolean newRequired) {
    UserDto userDto = userRepository.findUserById(fromString(userId));
    otpService.resendOTP(userDto.getUserId(), userDto.getMobileNumber(), newRequired, LOGIN);
    return userDto.getUserId();
  }
}
