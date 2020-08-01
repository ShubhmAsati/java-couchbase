package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.ParkedUserEntity;
import com.auth0.jobportal.entity.UsersEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaParkedUserRepository extends JpaRepository<ParkedUserEntity, UUID> {

  ParkedUserEntity findByMobileNumber(String mobileNumber);

}
