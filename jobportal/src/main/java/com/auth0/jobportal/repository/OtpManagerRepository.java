package com.auth0.jobportal.repository;

import static com.auth0.jobportal.converter.OtpDetailsConverter.toEntity;
import static com.auth0.jobportal.converter.OtpDetailsConverter.toOtpDetailsDto;

import com.auth0.jobportal.entity.OtpManagerEntity;
import com.auth0.jobportal.model.OtpDetailsDto;
import com.auth0.jobportal.repository.jpa.JpaOtpManagerRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OtpManagerRepository {

  private final JpaOtpManagerRepository jpaOtpManagerRepository;

  public void saveOtp(OtpDetailsDto otpDetailsDto){
    jpaOtpManagerRepository.save(toEntity(otpDetailsDto));
  }

  public OtpDetailsDto getOtpDetails(UUID userId){
    return toOtpDetailsDto(jpaOtpManagerRepository.findByUserId(userId));
  }

}
