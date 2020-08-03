package com.auth0.jobportal.repository;

import com.auth0.jobportal.entity.JobPostProfileEntity;
import com.auth0.jobportal.entity.JobReviewsEntity;
import com.auth0.jobportal.repository.jpa.JpaJobReviewsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JobReviewsRepository {
    private final JpaJobReviewsRepository jpaJobReviewsRepository;

    public Optional<JobReviewsEntity> findById(UUID id){
        return jpaJobReviewsRepository.findById(id);
    }

    public JobReviewsEntity saveJob(JobReviewsEntity jobReviewsEntity){
        return jpaJobReviewsRepository.save(jobReviewsEntity);
    }

}
