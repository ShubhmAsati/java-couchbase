package com.auth0.jobportal.controller;

import com.auth0.jobportal.constants.ApplicationConstants;
import com.auth0.jobportal.model.JobPostProfileDto;
import com.auth0.jobportal.model.response.JobPostProfiles;
import com.auth0.jobportal.service.JobSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(name= ApplicationConstants.JOBS_SEARCH)
@RequiredArgsConstructor
public class JobSearchController {

    private final JobSearchService jobSearchService;

    //retrieve
    @GetMapping("/get-def-jobs")
    public ResponseEntity<JobPostProfiles> getJobsByDefaultLocation
            (@Valid @RequestParam("Latitude")Double latitude,@Valid @RequestParam("Latitude")Double longitude,
             @Valid @RequestParam("Latitude")Integer pageNo){
        return ResponseEntity.status(HttpStatus.FOUND).body(jobSearchService.getDefaultJobs(latitude,longitude,pageNo));
    }



}
