package com.auth0.jobportal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {

  private String city;

  private String state;

  private String country;

  @Column(name = "pin_code")
  private int pinCode;

  private String landmark;

  @Column(name = "address_line_1")
  private String addressLine1;

  @Column(name = "geo_location")
  private Point geoLocation;

  @OneToOne(mappedBy = "address")
  private UserDetailsEntity userDetailsEntity;

}
