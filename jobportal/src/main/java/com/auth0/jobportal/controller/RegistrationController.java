package com.auth0.jobportal.controller;

import static com.auth0.jobportal.constants.ApplicationConstants.CONTEXT_URL;
import static com.auth0.jobportal.converter.OTPRequestConverter.toDto;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import com.auth0.jobportal.converter.ParkedUserConverter;
import com.auth0.jobportal.model.ParkedUserDto;
import com.auth0.jobportal.model.request.RegistrationStepOneRequest;
import com.auth0.jobportal.model.request.VerifyOTPRequest;
import com.auth0.jobportal.model.response.JobPortalResponse;
import com.auth0.jobportal.service.UserRegistrationService;
import com.auth0.jobportal.util.JwtUtil;
import com.auth0.jobportal.validator.RequestValidator;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CONTEXT_URL + "/register/v1")
@RequiredArgsConstructor
public class RegistrationController {

  private final UserRegistrationService userRegistrationService;
  private final ParkedUserConverter parkedUserConverter;
  private final RequestValidator requestValidator;
  private final JwtUtil jwtUtil;

  @PostMapping("/step-one")
  public ResponseEntity<JobPortalResponse> registrationStepOne(
      @Valid @RequestBody RegistrationStepOneRequest registrationStepOneRequest) {
    ParkedUserDto parkedUserDto = userRegistrationService
        .registrationStepOne(parkedUserConverter.toParkedUserDto(registrationStepOneRequest));
    return ResponseEntity.status(HttpStatus.CREATED).body(parkedUserConverter.toResponse(
        parkedUserDto));
  }

  @PostMapping("/verify-otp")
  public ResponseEntity<?> verifyOTP(
      @Valid @RequestBody VerifyOTPRequest verifyOTPRequest) {
    String userId = userRegistrationService.verifyOTP(toDto(verifyOTPRequest));
    return ResponseEntity.status(HttpStatus.OK)
        .headers(httpHeaders -> httpHeaders.add(AUTHORIZATION, jwtUtil.generateToken(userId)))
        .build();
  }

  @GetMapping("/resend-otp/{userId}")
  public ResponseEntity<?> resendOtp(@PathVariable(value = "userId") String userId,
      @RequestParam(value = "newRequired", defaultValue = "false", required = false) Boolean newRequired) {
    userRegistrationService
        .resendOTP(requestValidator.validateAndReturnUserId(userId), newRequired);
    return ResponseEntity.ok().build();
  }

}
