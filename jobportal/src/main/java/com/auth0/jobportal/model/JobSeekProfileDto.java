package com.auth0.jobportal.model;

import com.auth0.jobportal.entity.AddressEntity;
import com.auth0.jobportal.entity.UsersEntity;
import com.vladmihalcea.hibernate.type.range.Range;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class JobSeekProfileDto {

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
    private long compensation;

}
