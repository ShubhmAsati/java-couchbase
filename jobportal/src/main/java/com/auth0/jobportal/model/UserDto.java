package com.auth0.jobportal.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

  private UUID userId;

  private String email;

  private String mobileNumber;

  private String password;

  private String userType;

  private Boolean isActive;

  private UserDetailsDto userDetailsDto;

}
