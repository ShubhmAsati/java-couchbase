package com.auth0.jobportal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="ADDRESS")
public class AddressEntity extends BaseEntity{

    @Id
    @Column(name="")
    private long addressId;

    @Column(name="")
    private String city;

    @Column(name="")
    private String state;

    @Column(name="")
    private String country;

    @Column(name="")
    private int pinCode;

    @Column(name="")
    private String landmark;

    @Column(name="")
    private String addressLine1;

    @Column(name="")
    private Point geoLocation;


}
