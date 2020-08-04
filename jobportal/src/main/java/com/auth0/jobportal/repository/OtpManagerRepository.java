package com.auth0.jobportal.repository;

import static com.auth0.jobportal.converter.OtpDetailsConverter.toEntity;
import static com.auth0.jobportal.converter.OtpDetailsConverter.toOtpDetailsDto;

import com.auth0.jobportal.enums.OtpType;
import com.auth0.jobportal.exception.NotFoundException;
import com.auth0.jobportal.model.OtpDetailsDto;
import com.auth0.jobportal.repository.jpa.JpaOtpManagerRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OtpManagerRepository {

  private final JpaOtpManagerRepository jpaOtpManagerRepository;

  public OtpDetailsDto saveOtp(OtpDetailsDto otpDetailsDto) {
    return toOtpDetailsDto(jpaOtpManagerRepository.save(toEntity(otpDetailsDto)));
  }

  public OtpDetailsDto getOtpDetails(UUID userId, OtpType otpType) {
    return toOtpDetailsDto(jpaOtpManagerRepository.findByUserIdAndOtpType(userId, otpType)
        .orElseThrow(() -> new NotFoundException("User does not exist.")));
  }

  public void deleteByUserId(UUID id) {
    jpaOtpManagerRepository.deleteById(id);
  }

}
