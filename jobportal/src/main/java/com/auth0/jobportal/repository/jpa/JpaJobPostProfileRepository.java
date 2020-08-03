package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.JobPostProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import java.util.UUID;

@Repository
public interface JpaJobPostProfileRepository extends JpaRepository<JobPostProfileEntity, UUID> {

    Page<JobPostProfileEntity> findByUserId(UUID id, Pageable pageable);

    void deleteById(UUID id);

}
