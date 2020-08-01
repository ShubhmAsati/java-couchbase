//package com.auth0.jobportal.entity;
//
//import com.vladmihalcea.hibernate.type.range.Range;
//import lombok.Getter;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//
//import javax.persistence.*;
//import java.sql.Date;
//
//@MappedSuperclass
//@Getter
//public abstract class JobProfileEntity extends BaseEntity {
//
//    @Id
//    @Column(name = "")
//    private long jobId;
//
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "", referencedColumnName = "")
//    private UsersEntity user;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "", referencedColumnName = "")
//    private AddressEntity address;
//
//    @Column(name = "")
//    private String jobDescription;
//
//    @Column(name = "")
//    private String jobType;
//
//    @Column(name = "")
//    private long metaData;
//
//    @Column(name = "")
//    private Range<Integer> workingHours;
//
//    @Column(name = "")
//    private boolean isDeleted;
//
//    @Column(name = "")
//    private long compensation;
//
//}
