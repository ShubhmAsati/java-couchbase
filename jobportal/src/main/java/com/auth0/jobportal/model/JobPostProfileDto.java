package com.auth0.jobportal.model;


import com.auth0.jobportal.entity.AddressEntity;
import com.auth0.jobportal.entity.UsersEntity;
import com.vladmihalcea.hibernate.type.range.Range;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

@Data
@Builder
public class JobPostProfileDto {


    private UUID jobId;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private UsersEntity user;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private AddressEntity address;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String jobDescription;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String jobType;


    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private Range<Integer> workingHours;


    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private Range<Integer> compensation;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private boolean status;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private char gender;

    private long applicants;

    private String metadata;


}
