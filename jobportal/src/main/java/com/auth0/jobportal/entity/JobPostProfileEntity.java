package com.auth0.jobportal.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.range.Range;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JOB_POST_PROFILE")
@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class
)
public class JobPostProfileEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UsersEntity user;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
    private Boolean isDeleted;

    private Range<Integer> compensation;

    private Boolean status;

    private Integer applicants;

    private String gender;
}
