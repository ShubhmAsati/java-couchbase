package com.auth0.jobportal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersEntity extends BaseEntity{
    @Id
    @Column(name="")
    private  long userId;

    @Column(name="")
    private  String email;

    @Column(name="")
    private  String mobileNumber;

    @Column(name="")
    private  String password;

    @Column(name="")
    private  AddressEntity userType;

}
