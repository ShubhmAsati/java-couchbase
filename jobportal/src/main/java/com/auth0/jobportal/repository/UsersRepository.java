package com.auth0.jobportal.repository;

import com.auth0.jobportal.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity,Long> {

}
