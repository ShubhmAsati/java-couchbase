package com.auth0.jobportal.controller;

import com.auth0.jobportal.constants.ApplicationConstants;
import com.auth0.jobportal.model.JobPostProfileDto;
import com.auth0.jobportal.model.JobReviewsDto;
import com.auth0.jobportal.model.response.JobPostProfiles;
import com.auth0.jobportal.service.JobPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(name= ApplicationConstants.JOBS_URL)
@RequiredArgsConstructor
public class JobPostController {


    private final JobPostService jobPostService;

    //create
    //job
    @PostMapping("/post-job")
    public ResponseEntity<JobPostProfileDto> postJob(@Valid @RequestBody JobPostProfileDto jobPostProfileDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPostService.postJob(jobPostProfileDto));
    }

    //reviews


    //retrieve
    //byID
    @GetMapping("/get-job-post")
    public ResponseEntity<JobPostProfileDto> getJobById(@Valid @RequestParam("Id") UUID id){
        return ResponseEntity.status(HttpStatus.FOUND).body(jobPostService.getJobById(id));
    }

    //by user
    @GetMapping("/get-job-posts-by-poster")
    public ResponseEntity<JobPostProfiles> getJobByJobPoster(@Valid @RequestParam("Id") UUID userId){
        return ResponseEntity.status(HttpStatus.FOUND).body(jobPostService.getJobByJobPoster(userId));
    }

    @GetMapping("/get-job-posts-by-poster-at-page")
    public ResponseEntity<JobPostProfiles> getJobByJobPoster
            (@Valid @RequestParam("Id") UUID userId,@Valid @RequestParam("PageNo") Integer pageNo){
        return ResponseEntity.status(HttpStatus.FOUND).body(jobPostService.getJobByJobPosterAtPage(userId,pageNo));
    }

//    @GetMapping("/getJobPostsByLocation")
//    public ResponseEntity<JobPostProfiles> getJobByLocation
//            (@Valid @RequestParam("Id") UUID userId,@Valid @RequestParam("Radius") int radius){0

//        return ResponseEntity.status(HttpStatus.FOUND).body(jobPostService.getJobByLocation(userId,radius));
//    }


    //reviews
    @GetMapping("/get-job-reviews")
    public ResponseEntity<JobReviewsDto> getJobReviews(@Valid @RequestParam("Id") UUID jobId){
        return ResponseEntity.status(HttpStatus.FOUND).body(jobPostService.getJobReviews(jobId));
    }

    //update
    //job
    @PutMapping("/update-job-post")
    public ResponseEntity<?> updateJobById(@Valid @RequestBody JobPostProfileDto jobPostProfileDto){
        jobPostService.updateJobById(jobPostProfileDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    //review
    @PutMapping("/update-reviews")
    public ResponseEntity<?>  updateReviews(JobReviewsDto jobReviewsDto){
        jobPostService.updateReviews(jobReviewsDto);
        return ResponseEntity.status(HttpStatus.GONE).body(null);
    }

    //delete
    @DeleteMapping("/delete-job")
    public ResponseEntity<?> deleteJobById(@Valid @RequestParam("Id") UUID jobId){
        jobPostService.deleteByJobId(jobId);
        return ResponseEntity.status(HttpStatus.GONE).body(null);
    }



//    @GetMapping("/postJob")
//    public void postJob(){
//
//    }


}
