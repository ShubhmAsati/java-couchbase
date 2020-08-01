package com.auth0.jobportal.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StepTwoDto {

  private UUID userId;
  private Integer otp;

}
