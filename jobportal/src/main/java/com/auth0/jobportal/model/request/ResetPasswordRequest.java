package com.auth0.jobportal.model.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResetPasswordRequest {

  @NotBlank(message = "password should not be null or blank")
  private String password;

}
