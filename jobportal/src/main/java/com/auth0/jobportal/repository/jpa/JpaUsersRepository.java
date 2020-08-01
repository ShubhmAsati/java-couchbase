package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.UsersEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUsersRepository extends JpaRepository<UsersEntity, UUID> {

  Optional<UsersEntity> findByMobileNumber(String mobileNumber);

}
