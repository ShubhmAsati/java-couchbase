package com.auth0.jobportal.repository;

import com.auth0.jobportal.entity.JobSeekProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekProfileRepository extends CrudRepository<JobSeekProfileEntity,Long> {

}
