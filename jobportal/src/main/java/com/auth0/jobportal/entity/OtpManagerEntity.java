package com.auth0.jobportal.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "otp_manager")
public class OtpManagerEntity extends BaseEntity{

  public Integer otp;
  @Column(name = "user_id", unique = true)
  public UUID userId;

  @Column(name = "resend_count")
  public Integer resendCount;

}
