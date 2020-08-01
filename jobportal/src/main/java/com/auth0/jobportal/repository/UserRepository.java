package com.auth0.jobportal.repository;

import static com.auth0.jobportal.converter.UserConverter.toUserDto;
import static com.auth0.jobportal.converter.UserConverter.toUserEntity;

import com.auth0.jobportal.model.UserDto;
import com.auth0.jobportal.repository.jpa.JpaUsersRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

  private final JpaUsersRepository jpaUsersRepository;

  public UserDto findUserByMobileNumber(String mobileNumber) {
    return toUserDto(jpaUsersRepository.findByMobileNumber(mobileNumber));
  }

  public UserDto findUserById(UUID userId){
    return toUserDto(jpaUsersRepository.findById(userId).get());
  }


  public UserDto saveUser(UserDto userDto) {
    return toUserDto(jpaUsersRepository.save(toUserEntity(userDto)));
  }
}
