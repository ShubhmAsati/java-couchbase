package com.auth0.jobportal.repository;

import com.auth0.jobportal.entity.JobPostProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostProfileRepository extends CrudRepository<JobPostProfileEntity,Long> {

}
