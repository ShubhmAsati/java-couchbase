package com.auth0.jobportal.entity;

import com.vladmihalcea.hibernate.type.range.Range;
import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JOB_SEEKER_PROFILE")
public class JobSeekerProfileEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_ID")
    private UUID id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UsersEntity user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    private AddressEntity address;

    @Column(name = "JOB_DESC")
    private String jobDescription;

    @Column(name = "JOB_TYPE")
    private String jobType;


    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String metaData;

    @Column(name = "WORKING_HOURS")
    private Range<Integer> workingHours;

    @Column(name = "IS_DELETED")
    private boolean isDeleted;

    private Range<Integer> compensation;

}
