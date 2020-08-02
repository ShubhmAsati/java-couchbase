package com.auth0.jobportal.constants;

public class ApplicationConstants {

  private ApplicationConstants() {
  }

  public static final String CONTEXT_URL = "/jobPortal";
  public static final String PHONE_NUMBER_VALIDATION_REGEX = "[+]91[6-9][0-9]{9}";
  public static final String OTP_MESSAGE = "Your Job portal verification code is: %s \n Do not share with anyone.";
  public static final String ERR_MSG_EXPIRED_OTP = "Your otp has been expired.";
  public static final String ERR_MSG_INVALID_OTP = "Invalid otp, please try again.";
  public static final String ERR_MSG_INVALID_UUID = "Should be a valid UUID.";
  public static final String ERR_MSG_INVALID_PHONE_NUMBER = "mobileNumber should be a valid number of 10 digits with +91";
  public static final String ERR_MSG_INVALID_PASSWORD = "Invalid password, please try again";

}
