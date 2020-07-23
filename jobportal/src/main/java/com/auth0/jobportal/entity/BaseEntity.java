package com.auth0.jobportal.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

@MappedSuperclass
@Getter
public abstract class BaseEntity {


    @Column(name="")
    private String UUID;

    @CreatedDate
    @Column(name = "")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "")
    private Date updatedDate;
}
