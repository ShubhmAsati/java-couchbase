package com.auth0.jobportal.model;


import lombok.Data;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddressDto {

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private long addressId;

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String city;

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String state;

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String country;

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private int pinCode;

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String landmark;

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private String addressLine1;

    @NotBlank(message=" Cannnot be Blank")
    @NotNull(message = " Cannot be NUll ")
    private Point geoLocation;



}
