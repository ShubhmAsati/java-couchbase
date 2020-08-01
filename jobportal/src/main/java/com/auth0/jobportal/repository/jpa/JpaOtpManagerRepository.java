package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.OtpManagerEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOtpManagerRepository extends JpaRepository<OtpManagerEntity, UUID> {

  OtpManagerEntity findByUserId(UUID userId);

}