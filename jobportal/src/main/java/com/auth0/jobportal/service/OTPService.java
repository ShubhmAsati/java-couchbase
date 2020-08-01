package com.auth0.jobportal.service;

import static com.auth0.jobportal.constants.ApplicationConstants.ERR_MSG_EXPIRED_OTP;
import static com.auth0.jobportal.constants.ApplicationConstants.ERR_MSG_INVALID_OTP;
import static com.auth0.jobportal.constants.ApplicationConstants.OTP_MESSAGE;
import static java.lang.Math.random;
import static java.lang.String.format;
import static java.util.Collections.singletonList;

import com.auth0.jobportal.config.PropertyConfig;
import com.auth0.jobportal.exception.InvalidOTPException;
import com.auth0.jobportal.model.ErrorDetails;
import com.auth0.jobportal.model.OtpDetailsDto;
import com.auth0.jobportal.model.StepTwoDto;
import com.auth0.jobportal.repository.OtpManagerRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OTPService {

  private final PropertyConfig propertyConfig;
  private final OtpManagerRepository otpManagerRepository;

  public void generateAndSendOTP(UUID userId, String phoneNumber, Boolean isNew) {
    if (isNew) {
      otpManagerRepository.saveOtp(buildOtpDetailsDto(userId, phoneNumber));
    } else {
      OtpDetailsDto otpDetailsDto = otpManagerRepository.getOtpDetails(userId);
      otpDetailsDto.setOtp(sendOTP(phoneNumber));
      otpManagerRepository.saveOtp(otpDetailsDto);
    }
  }

  private OtpDetailsDto buildOtpDetailsDto(UUID userId, String phoneNumber) {
    return OtpDetailsDto.builder()
        .userId(userId)
        .otp(sendOTP(phoneNumber))
        .build();
  }

  private Integer sendOTP(String phoneNumber) {
    Integer otp = generateOtp();
    log.info(format(OTP_MESSAGE, otp));
    Message.creator(new PhoneNumber(phoneNumber), // to
        new PhoneNumber(propertyConfig.getTwilioAccountPhoneNumber()), // from
        format(OTP_MESSAGE, otp)).create();
    return otp;
  }

  private Integer generateOtp() {
    return (int) (random() * 1000000);
  }

  public void validateOtp(StepTwoDto stepTwoDto) {
    OtpDetailsDto otpDetailsDto = otpManagerRepository.getOtpDetails(stepTwoDto.getUserId());
    validateExpiry(otpDetailsDto.getLastUpdatedAt());
    if (!otpDetailsDto.getOtp().equals(stepTwoDto.getOtp())) {
      throw new InvalidOTPException(buildErrorDetails(ERR_MSG_INVALID_OTP));
    }
  }

  private void validateExpiry(LocalDateTime dateTime) {
    long seconds = ChronoUnit.SECONDS.between(dateTime, LocalDateTime.now());
    if (propertyConfig.getOtpExpirationTimeInMinutes().longValue() * 60 < seconds) {
      throw new InvalidOTPException(buildErrorDetails(ERR_MSG_EXPIRED_OTP));
    }
  }

  private List<ErrorDetails> buildErrorDetails(String message) {
    return singletonList(ErrorDetails.builder()
        .message(message)
        .build());
  }

  public void resendOTP(UUID userId) {
    OtpDetailsDto otpDetailsDto = otpManagerRepository.getOtpDetails(userId);
    if (propertyConfig.getOtpResendCount().equals(otpDetailsDto.getResendCount())) {
      throw new InvalidOTPException(buildErrorDetails(ERR_MSG_EXPIRED_OTP));
    }
    otpDetailsDto.setResendCount(otpDetailsDto.getResendCount() + 1);
    otpManagerRepository.saveOtp(otpDetailsDto);

  }
}
