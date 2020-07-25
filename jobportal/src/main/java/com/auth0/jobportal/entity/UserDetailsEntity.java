package com.auth0.jobportal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailsEntity extends BaseEntity{

    @Id
    @Column(name="")
    private  long userId;

    @Column(name="")
    private  String email;

    @Column(name="")
    private  String firstName;

    @Column(name="")
    private  String lastName;

    @Column(name="")
    private  AddressEntity address;



}
