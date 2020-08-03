package com.auth0.jobportal.service;

import com.auth0.jobportal.converter.JobPostProfileConverter;
import com.auth0.jobportal.converter.JobReviewsConverter;
import com.auth0.jobportal.entity.JobPostProfileEntity;
import com.auth0.jobportal.exception.InvalidJobIdException;
import com.auth0.jobportal.exception.InvalidJobReviewCreationException;
import com.auth0.jobportal.exception.JobFinderBaseException;
import com.auth0.jobportal.model.JobPostProfileDto;
import com.auth0.jobportal.model.JobReviewsDto;
import com.auth0.jobportal.model.response.JobPostProfiles;
import com.auth0.jobportal.repository.JobPostProfileRepository;

import com.auth0.jobportal.repository.JobReviewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobPostService {


    private final JobPostProfileRepository jobPostProfileRepository;
    private  final JobReviewsRepository jobReviewsRepository;

    private final JobPostProfileConverter jobPostProfileConverter;
    private final JobReviewsConverter jobReviewsConverter;

    //create
    public JobPostProfileDto postJob(JobPostProfileDto jobPostProfileDto) throws JobFinderBaseException {
        JobPostProfileEntity jobPostProfileEntity=
                jobPostProfileConverter.createJobDtoToToEntity(jobPostProfileDto);
        jobPostProfileEntity.setApplicants(0);
        jobPostProfileRepository.saveJob(jobPostProfileEntity);
        return jobPostProfileConverter.createJobEntityToToDto(jobPostProfileEntity);

    }

    //retrieve
    public JobPostProfileDto getJobById(UUID id){
        return jobPostProfileConverter.createJobEntityToToDto(
                jobPostProfileRepository.findById(id).orElseThrow(()-> new InvalidJobIdException(id)));

    }


    public JobPostProfiles getJobByJobPoster(UUID userId){

        List<JobPostProfileDto> jobProfiles=new LinkedList<>();
        jobPostProfileRepository.findByUserIdWithPage(userId,0).forEach((a)->{
            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
        });
        List<JobPostProfileDto> jobProfilesNext=new LinkedList<>();
        jobPostProfileRepository.findByUserIdWithPage(userId,1).forEach((a)->{
            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
        });

        return new JobPostProfiles(jobProfiles,jobProfilesNext,null);
    }

    public JobPostProfiles getJobByJobPosterAtPage(UUID userId,int page){
        List<JobPostProfileDto> jobProfiles=new LinkedList<>();

        Page<JobPostProfileEntity> cur=jobPostProfileRepository.findByUserIdWithPage(userId,page);
        cur.forEach((a)->{
            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
        });

        List<JobPostProfileDto> jobProfilesNext=null;
        if(page!=cur.getTotalPages()) {
            jobProfilesNext = new LinkedList<>();
            jobPostProfileRepository.findByUserIdWithPage(userId, page + 1).forEach((a) -> {
                jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
            });
        }

        List<JobPostProfileDto> jobProfilesPrev=null;
        if(page!=0) {
            jobProfilesPrev= new LinkedList<>();
            jobPostProfileRepository.findByUserIdWithPage(userId, page - 1).forEach((a) -> {
                jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
            });
        }

        return new JobPostProfiles(jobProfiles,jobProfilesNext,jobProfilesPrev);
    }

    public JobReviewsDto getJobReviews(UUID jobId){
        return jobReviewsConverter.reviewsEntityToDto(
                jobReviewsRepository.findById(jobId)
                        .orElseThrow(()-> new InvalidJobReviewCreationException(jobId)));
    }



//    public JobPostProfiles getJobByLocation(UUID userId,int radius){
//
//
//
//
//
//
//        List<JobPostProfileDto> jobProfiles=new LinkedList<>();
//        jobPostProfileRepository.findByUserIdBetweenLocation(userId,0).forEach((a)->{
//            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
//        });
//        List<JobPostProfileDto> jobProfilesNext=new LinkedList<>();
//        jobPostProfileRepository.findByUserIdBetweenLocation(userId,1).forEach((a)->{
//            jobProfiles.add(jobPostProfileConverter.createJobEntityToToDto(a));
//        });
//
//        return new JobPostProfiles(jobProfiles,jobProfilesNext,null);
//    }

    //update
    public void updateJobById(JobPostProfileDto jobPostProfileDto){
        jobPostProfileRepository.saveJob(jobPostProfileConverter.createJobDtoToToEntity(jobPostProfileDto));
    }

    public void updateReviews(JobReviewsDto jobReviewsDto){
        jobReviewsRepository.saveJob(jobReviewsConverter.reviewsDtoToEntity(jobReviewsDto));
    }

    //delete

    public void deleteByJobId(UUID jobId){
        jobPostProfileRepository.deleteByJobiId(jobId);
    }



}