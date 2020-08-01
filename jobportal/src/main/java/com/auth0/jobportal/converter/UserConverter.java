package com.auth0.jobportal.converter;

import static java.lang.Boolean.TRUE;

import com.auth0.jobportal.entity.AddressEntity;
import com.auth0.jobportal.entity.UserDetailsEntity;
import com.auth0.jobportal.entity.UsersEntity;
import com.auth0.jobportal.model.Address;
import com.auth0.jobportal.model.ParkedUserDto;
import com.auth0.jobportal.model.UserDetailsDto;
import com.auth0.jobportal.model.UserDto;

public class UserConverter {

  private UserConverter() {
  }

  public static UserDto toUserDto(UsersEntity usersEntity) {
    return UserDto.builder()
        .email(usersEntity.getEmail())
        .userId(usersEntity.getId())
        .userType(usersEntity.getUserType())
        .mobileNumber(usersEntity.getMobileNumber())
        .password(usersEntity.getPassword())
        .isActive(usersEntity.getIsActive())
        .userDetailsDto(buildUserDetailDto(usersEntity.getUserDetailsEntity()))
        .build();
  }

  private static UserDetailsDto buildUserDetailDto(UserDetailsEntity userDetailsEntity) {
    return UserDetailsDto.builder()
        .firstName(userDetailsEntity.getFirstName())
        .lastName(userDetailsEntity.getLastName())
        .email(userDetailsEntity.getEmail())
        .address(buildAddressDto(userDetailsEntity.getAddress()))
        .build();
  }

  private static Address buildAddressDto(AddressEntity address) {
    return Address.builder()
        .addressLine1(address.getAddressLine1())
        .city(address.getCity())
        .country(address.getCountry())
        .landmark(address.getLandmark())
        .pinCode(address.getPinCode())
        .state(address.getState())
        .build();
  }

  public static UserDto toUserDto(ParkedUserDto parkedUserDto) {
    return UserDto.builder()
        .mobileNumber(parkedUserDto.getMobileNumber())
        .password(parkedUserDto.getPassword())
        .isActive(TRUE)
        .userDetailsDto(buildUserDetailDto(parkedUserDto))
        .build();
  }

  private static UserDetailsDto buildUserDetailDto(ParkedUserDto parkedUserDto) {
    return UserDetailsDto.builder()
        .firstName(parkedUserDto.getFirstName())
        .lastName(parkedUserDto.getLastName())
        .build();
  }

  public static UsersEntity toUserEntity(UserDto userDto) {
    return UsersEntity.builder()
        .email(userDto.getEmail())
        .isActive(userDto.getIsActive())
        .mobileNumber(userDto.getMobileNumber())
        .password(userDto.getPassword())
        .userType(userDto.getUserType())
        .userDetailsEntity(buildUserDetailsEntity(userDto.getUserDetailsDto()))
        .build();
  }

  private static UserDetailsEntity buildUserDetailsEntity(UserDetailsDto userDetailsDto) {
    return UserDetailsEntity.builder()
        .email(userDetailsDto.getEmail())
        .firstName(userDetailsDto.getFirstName())
        .lastName(userDetailsDto.getLastName())
        .address(buildAddressEntity(userDetailsDto.getAddress()))
        .build();
  }

  private static AddressEntity buildAddressEntity(Address address) {
    return AddressEntity.builder()
        .addressLine1(address.getAddressLine1())
        .city(address.getCity())
        .country(address.getCountry())
        .landmark(address.getLandmark())
        .pinCode(address.getPinCode())
        .state(address.getState())
        .build();
  }

}
