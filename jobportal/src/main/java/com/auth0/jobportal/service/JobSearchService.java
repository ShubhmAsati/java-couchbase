package com.auth0.jobportal.service;

import com.auth0.jobportal.entity.JobPostProfileEntity;
import com.auth0.jobportal.model.JobPostProfileDto;
import com.auth0.jobportal.model.response.JobPostProfiles;
import com.auth0.jobportal.repository.GeoLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSearchService {

    private final GeoLocationRepository geoLocationRepository;


   public JobPostProfiles getDefaultJobs(Double latitude,Double longitude,Integer pageNo){
//
//        List<JobPostProfileDto> jobProfiles=new LinkedList<>();
//
//        Page<JobPostProfileEntity> cur=jobPostProfileRepository.findByUserIdWithPage(userId,page);
//        cur.forEach((a)->{
//            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
//        });
//
//
//
//        List<JobPostProfileDto> jobProfiles=new LinkedList<>();
//        geoLocationRepository.findByUserIdBetweenLocation(userId,0).forEach((a)->{
//            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
//        });
//        List<JobPostProfileDto> jobProfilesNext=new LinkedList<>();
//        geoLocationRepository.findByUserIdBetweenLocation(userId,1).forEach((a)->{
//            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
//        });
//
//        return new JobPostProfiles(jobProfiles,jobProfilesNext,null);
       return null;
    }



}
