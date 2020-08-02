package com.auth0.jobportal.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDto {

  private String mobileNumber;
  private String password;
  private Boolean isPasswordRequired;

}
