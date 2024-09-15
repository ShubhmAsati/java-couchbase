package com.auth0.jobportal.converter;

import com.auth0.jobportal.entity.JobPostProfileEntity;
import com.auth0.jobportal.model.JobPostProfileDto;
import com.auth0.jobportal.model.request.JobProfileRequest;
import com.vladmihalcea.hibernate.type.range.Range;
import org.springframework.stereotype.Component;


public class JobPostProfileConverter {

//    public static JobPostProfileEntity convertJobPostProfileConverterToEntity(JobPostProfileDto jobPostProfileDto){
//
//        return JobPostProfileEntity.builder()
//                .id(jobPostProfileDto.getJobId())
//                .applicants(jobPostProfileDto.)
//                .gender(jobPostProfileDto.getGender()).build();
//    }

    public static JobPostProfileEntity createJobDtoToToEntity(JobPostProfileDto jobPostProfileDto){
        return JobPostProfileEntity.builder()
                .user(jobPostProfileDto.getUser())
                .address(jobPostProfileDto.getAddress())
                .jobDescription(jobPostProfileDto.getJobDescription())
                .jobType(jobPostProfileDto.getJobType())
                .metaData(jobPostProfileDto.getMetadata())
                .workingHours(jobPostProfileDto.getWorkingHours())
                .compensation(jobPostProfileDto.getCompensation())
                .gender(jobPostProfileDto.getGender())
                .build();
    }

    public static JobPostProfileDto createJobEntityToToDto(JobPostProfileEntity jobPostProfileEntity){
        return JobPostProfileDto.builder()
                .jobId(jobPostProfileEntity.getId())
                .user(jobPostProfileEntity.getUser())
                .address(jobPostProfileEntity.getAddress())
                .jobDescription(jobPostProfileEntity.getJobDescription())
                .jobType(jobPostProfileEntity.getJobType())
                .metadata(jobPostProfileEntity.getMetaData())
                .workingHours(jobPostProfileEntity.getWorkingHours())
                .compensation(jobPostProfileEntity.getCompensation())
                .status(jobPostProfileEntity.getStatus())
                .gender(jobPostProfileEntity.getGender())
                .applicants(jobPostProfileEntity.getApplicants())
                .build();
    }

    public static JobPostProfileEntity postRequestToEntity(JobProfileRequest jobProfileRequest){
        Range<Integer> workHours=Range.closed(jobProfileRequest.getWorkingHoursLow(),jobProfileRequest.getWorkingHoursHigh());
        Range<Integer> compensation=Range.closed(jobProfileRequest.getCompensationLow(),jobProfileRequest.getCompensationHigh());
        return JobPostProfileEntity.builder()
                .user(jobProfileRequest.getUser())
                .address(jobProfileRequest.getAddress())
                .jobDescription(jobProfileRequest.getJobDescription())
                .jobType(jobProfileRequest.getJobType())
                .metaData(jobProfileRequest.getMetadata())
                .workingHours(workHours)
                .compensation(compensation)
                .gender(jobProfileRequest.getGender())
                .build();

    }

}
