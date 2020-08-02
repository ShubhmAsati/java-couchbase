package com.auth0.jobportal.controller;

import static com.auth0.jobportal.constants.ApplicationConstants.CONTEXT_URL;
import static com.auth0.jobportal.converter.OTPRequestConverter.toDto;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import com.auth0.jobportal.model.request.LoginRequest;
import com.auth0.jobportal.model.request.ResetPasswordRequest;
import com.auth0.jobportal.model.request.VerifyOTPRequest;
import com.auth0.jobportal.model.response.JobPortalResponse;
import com.auth0.jobportal.service.LoginService;
import com.auth0.jobportal.util.JwtUtil;
import com.auth0.jobportal.validator.RequestValidator;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CONTEXT_URL + "/login")
@RequiredArgsConstructor
public class LoginController {

  private final LoginService loginService;
  private final RequestValidator requestValidator;
  private final JwtUtil jwtUtil;

  @GetMapping("/v1/login-by-otp/{mobileNumber}")
  public ResponseEntity<JobPortalResponse> loginByMobileNumber(
      @PathVariable("mobileNumber") String mobileNumber) {
    requestValidator.validateMobileNumber(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK).body(
        JobPortalResponse.builder().userId(loginService.login(mobileNumber, TRUE)).build());
  }

  @PostMapping("/v1/login-by-password")
  public ResponseEntity<?> loginByPassword(@Valid @RequestBody LoginRequest loginRequest) {
    UUID userId = loginService
        .loginByPassword(loginRequest.getMobileNumber(), loginRequest.getPassword());
    return ResponseEntity.status(HttpStatus.OK).headers(
        httpHeaders -> httpHeaders.add(AUTHORIZATION, jwtUtil.generateToken(userId.toString())))
        .build();
  }

  @PostMapping("/v1/verify-otp")
  public ResponseEntity<?> verifyOTP(@Valid @RequestBody VerifyOTPRequest verifyOTPRequest,
      @RequestParam(value = "isLoginOTP") Boolean isLoginOTP) {
    UUID userId = loginService.verifyOTP(toDto(verifyOTPRequest), isLoginOTP);
    return ResponseEntity.status(HttpStatus.OK).headers(
        httpHeaders -> httpHeaders.add(AUTHORIZATION, jwtUtil.generateToken(userId.toString())))
        .build();
  }

  @GetMapping("/v1/forgot-password/{mobileNumber}")
  public ResponseEntity<JobPortalResponse> forgotPassword(
      @PathVariable("mobileNumber") String mobileNumber) {
    requestValidator.validateMobileNumber(mobileNumber);
    return ResponseEntity.status(HttpStatus.OK).body(
        JobPortalResponse.builder().userId(loginService.login(mobileNumber, FALSE)).build());
  }

  @PostMapping("/v2/reset-password")
  public ResponseEntity<?> resetPassword(
      @Valid @RequestBody ResetPasswordRequest resetPasswordRequest,
      @RequestHeader(AUTHORIZATION) String token) {
    loginService.resetPassword(resetPasswordRequest.getPassword(), token);
    return ResponseEntity.ok().build();
  }


}
