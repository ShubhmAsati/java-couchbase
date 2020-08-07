package com.auth0.jobportal.controller;

import com.auth0.jobportal.constants.ApplicationConstants;
import com.auth0.jobportal.constants.TypesEnum;
import com.auth0.jobportal.model.response.JobPostProfiles;
import com.auth0.jobportal.service.GeoLocatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(name= ApplicationConstants.SEARCH)
@RequiredArgsConstructor
public class SearchController {

    private final GeoLocatorService geoLocatorService;

    //retrieve
    @GetMapping("/jobs")
    public ResponseEntity<?> getJobs
            (@Valid @RequestParam("latitude") Optional<Double> latitude,
             @Valid @RequestParam("longitude")Optional<Double> longitude,
             @Valid @RequestParam("area")Optional<String> area,
             @Valid @RequestParam("city")Optional<String> city,
             @Valid @RequestParam("pageNo")Optional<Integer> pageNo,
             @Valid @RequestParam("radius")Optional<Integer> radius){
        if(latitude.isPresent() && longitude.isPresent())
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(geoLocatorService.getJobsByCoordinates(latitude.get(),longitude.get(),
                            pageNo.orElse(ApplicationConstants.DEFAULT_JOB_PAGE),radius.orElse(ApplicationConstants.DEFAULT_RADIUS)));
        else if(area.isPresent() || city.isPresent())
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(geoLocatorService.getJobsByLocation(area.orElse(city.get()),city.orElse(area.get()),
                            pageNo.orElse(ApplicationConstants.DEFAULT_JOB_PAGE),radius.orElse(ApplicationConstants.DEFAULT_RADIUS)));


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApplicationConstants.INSUFFICIENT_SEARCH_PARAMETERS);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers
            (@Valid @RequestParam("latitude") Optional<Double> latitude,
             @Valid @RequestParam("longitude")Optional<Double> longitude,
             @Valid @RequestParam("area")Optional<String> area,
             @Valid @RequestParam("city")Optional<String> city,
             @Valid @RequestParam("pageNo")Optional<Integer> pageNo,
             @Valid @RequestParam("radius")Optional<Integer> radius,
             @Valid @RequestParam("type")Optional<String> type){
        if(latitude.isPresent() && longitude.isPresent())
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(geoLocatorService.getUsersByCoordinates(latitude.get(),longitude.get(),
                            pageNo.orElse(ApplicationConstants.DEFAULT_JOB_PAGE),radius.orElse(ApplicationConstants.DEFAULT_RADIUS),
                            type.orElse(TypesEnum.SEEKER.getValue())));
        else if(area.isPresent() || city.isPresent())
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(geoLocatorService.getUsersByLocation(area.orElse(city.get()),city.orElse(area.get()),
                            pageNo.orElse(ApplicationConstants.DEFAULT_JOB_PAGE),
                            radius.orElse(ApplicationConstants.DEFAULT_RADIUS),
                            type.orElse(TypesEnum.SEEKER.getValue())));


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApplicationConstants.INSUFFICIENT_SEARCH_PARAMETERS);
    }

//lat,long/ar,city;desc,

}
