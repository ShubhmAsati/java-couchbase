package com.auth0.jobportal.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class RegistrationStepOneRequest {

  @Pattern(message = "mobileNumber should be a valid phone number of 10 digits with +91", regexp = "[+]91[6-9][0-9]{9}")
  private String mobileNumber;

  @NotBlank(message = "password should not be null or blank")
  private String password;

  @NotBlank(message = "firstName should not be null or blank")
  private String firstName;

  @NotBlank(message = "lastName should not be null or blank")
  private String lastName;

}
