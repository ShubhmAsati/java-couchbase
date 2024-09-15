package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.UserDetailsEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserDetailsRepository extends CrudRepository<UserDetailsEntity, UUID> {

    UserDetailsEntity save(UserDetailsEntity userDetailsEntity);

}
