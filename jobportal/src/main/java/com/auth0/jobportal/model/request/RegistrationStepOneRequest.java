package com.auth0.jobportal.model.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistrationStepOneRequest {

  @NotBlank(message = "should not be null or blank")
  private String mobileNumber;

  @NotBlank(message = "should not be null or blank")
  private String password;

  @NotBlank(message = "should not be null or blank")
  private String firstName;

  @NotBlank(message = "should not be null or blank")
  private String lastName;

}
