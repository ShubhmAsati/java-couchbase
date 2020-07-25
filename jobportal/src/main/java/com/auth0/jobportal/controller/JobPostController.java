package com.auth0.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobPostController {

    @PostMapping("/postJob")
    public void postJob(){

    }
    @GetMapping("/getJobById")
    public void getJobById(){

    }
    @GetMapping("/getJobByPoster")
    public void getJobByJobPoster(){

    }
    @GetMapping("/getJobComments")
    public void getJobComments(){

    }
//    @GetMapping("/postJob")
//    public void postJob(){
//
//    }


}
