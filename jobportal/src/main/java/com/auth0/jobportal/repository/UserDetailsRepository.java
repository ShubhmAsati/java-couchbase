package com.auth0.jobportal.repository;

import com.auth0.jobportal.entity.UserDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetailsEntity,Long> {

}
