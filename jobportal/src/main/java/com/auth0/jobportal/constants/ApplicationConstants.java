package com.auth0.jobportal.constants;

public class ApplicationConstants {

  private ApplicationConstants() {
  }

  public static final String CONTEXT_URL = "jobPortal";
  public static final String OTP_MESSAGE = "Your Job portal verification code is: %s \n Do not share with anyone.";
  public static final String ERR_MSG_EXPIRED_OTP = "Your otp has been expired.";
  public static final String ERR_MSG_INVALID_OTP = "Invalid otp, please try again.";
  public static final String ERR_MSG_INVALID_UUID = "Should be a valid UUID.";

}
