package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.JobReviewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaJobReviewsRepository extends CrudRepository<JobReviewsEntity, UUID> {

    @Override
    Optional<JobReviewsEntity> findById(UUID uuid);
}
