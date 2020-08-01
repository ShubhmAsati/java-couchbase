package com.auth0.jobportal.repository;

import com.auth0.jobportal.converter.ParkedUserConverter;
import com.auth0.jobportal.exception.EntityAlreadyExistException;
import com.auth0.jobportal.exception.NotFoundException;
import com.auth0.jobportal.model.ParkedUserDto;
import com.auth0.jobportal.repository.jpa.JpaParkedUserRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ParkedUserRepository {

  private final JpaParkedUserRepository jpaParkedUserRepository;
  private final ParkedUserConverter parkedUserConverter;

  public ParkedUserDto saveParkedUser(ParkedUserDto parkedUserDto, Boolean isValidationRequired) {
    if (isValidationRequired) {
      validateUserExistence(parkedUserDto);
    }
    return parkedUserConverter
        .toParkedUserDto(jpaParkedUserRepository.save(parkedUserConverter.toParkedUserEntity(
            parkedUserDto)));
  }

  private void validateUserExistence(ParkedUserDto parkedUserDto) {
    if (jpaParkedUserRepository.findByMobileNumber(parkedUserDto.getMobileNumber()).isPresent()) {
      throw new EntityAlreadyExistException("User exist, cannot update the entity.");
    }
  }

  public ParkedUserDto getParkedUserById(UUID userId) {
    return parkedUserConverter.toParkedUserDto(jpaParkedUserRepository.findById(userId).orElseThrow(() -> new NotFoundException("User does not exist.")));
  }
}
