package com.auth0.jobportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parked_user_entity")
public class ParkedUserEntity extends BaseEntity {

  @Column(name = "mobile_number")
  private String mobileNumber;

  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "is_verified")
  private Boolean isVerified;
}

