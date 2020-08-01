package com.auth0.jobportal.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OtpDetailsDto {

  private UUID otpId;
  private Integer otp;
  private LocalDateTime lastUpdatedAt;
  private UUID userId;
  private Integer resendCount;

}
