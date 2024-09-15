package com.auth0.jobportal.model;


import com.auth0.jobportal.entity.AddressEntity;
import com.auth0.jobportal.entity.UsersEntity;
import com.vladmihalcea.hibernate.type.range.Range;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
public class JobPostProfileDto {


    private UUID jobId;


    private UsersEntity user;


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
    private Boolean status;

    @NotBlank(message=" Cannot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String gender;

    private Integer applicants;

    private String metadata;


}
