package com.auth0.jobportal.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsDto {

  private UUID userDetailsId;

  private String email;

  private String firstName;

  private String lastName;

  private Address address;

}
