package com.auth0.jobportal.converter;

import com.auth0.jobportal.entity.JobPostProfileEntity;
import com.auth0.jobportal.model.JobPostProfileDto;

public class JobPostProfileConverter {

//    public static JobPostProfileEntity convertJobPostProfileConverterToEntity(JobPostProfileDto jobPostProfileDto){
//
//        return JobPostProfileEntity.builder()
//                .id(jobPostProfileDto.getJobId())
//                .applicants(jobPostProfileDto.)
//                .gender(jobPostProfileDto.getGender()).build();
//    }

    public JobPostProfileEntity createJobDtoToToEntity(JobPostProfileDto jobPostProfileDto){
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

    public JobPostProfileDto createJobEntityToToDto(JobPostProfileEntity jobPostProfileEntity){
        return JobPostProfileDto.builder()
                .jobId(jobPostProfileEntity.getId())
                .user(jobPostProfileEntity.getUser())
                .address(jobPostProfileEntity.getAddress())
                .jobDescription(jobPostProfileEntity.getJobDescription())
                .jobType(jobPostProfileEntity.getJobType())
                .metadata(jobPostProfileEntity.getMetaData())
                .workingHours(jobPostProfileEntity.getWorkingHours())
                .compensation(jobPostProfileEntity.getCompensation())
                .status(jobPostProfileEntity.isStatus())
                .gender(jobPostProfileEntity.getGender())
                .applicants(jobPostProfileEntity.getApplicants())
                .build();
    }




}
