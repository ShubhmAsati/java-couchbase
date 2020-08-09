package com.auth0.jobportal.model.request;

import com.auth0.jobportal.entity.AddressEntity;
import com.auth0.jobportal.entity.UsersEntity;
import com.vladmihalcea.hibernate.type.range.Range;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class JobProfileRequest {


    private UsersEntity user;


    private AddressEntity address;


    private String jobDescription;


    private String jobType;



    //private Range<Integer> workingHours;
    private Integer workingHoursLow;


    //private Range<Integer> workingHours;
    private Integer workingHoursHigh;



    //private Range<Integer> compensation;
    private Integer compensationLow;


    //private Range<Integer> compensation;
    private Integer compensationHigh;


    private Boolean status;


    private String gender;

    private Integer applicants;

    private String metadata;
}
