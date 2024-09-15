package com.auth0.jobportal.service;

import com.auth0.jobportal.constants.ApplicationConstants;
import com.auth0.jobportal.constants.TypesEnum;
import com.auth0.jobportal.entity.JobPostProfileEntity;
import com.auth0.jobportal.model.JobPostProfileDto;
import com.auth0.jobportal.model.response.JobPostProfiles;
import com.auth0.jobportal.repository.GeoLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GeoLocatorService {

    private final GeoLocationRepository geoLocationRepository;
    private final JobPostService jobPostService;


    public JobPostProfiles getJobsByCoordinates(Double latitude, Double longitude,
                                                Integer pageNo,Integer radius){
       double[] latLongs=calculateGeoLocDiff(latitude,longitude,radius);

        Page<UUID> jobs=geoLocationRepository.getObjectsByCoordinatesAndTypePerPage(latitude,longitude,pageNo,
                latLongs, TypesEnum.JOB.getValue());

        return jobPostService.getJobByIds(jobs.getContent(),pageNo);
    }

    public JobPostProfiles getJobsByLocation(String area, String city,
                                                Integer pageNo,Integer radius){
        //call google api
        double latitude=0;
        double longitude=0;
        double[] latLongs=calculateGeoLocDiff(latitude,longitude,radius);
        Page<UUID> jobs=geoLocationRepository.getObjectsByCoordinatesAndTypePerPage(latitude,longitude,pageNo,
                latLongs, TypesEnum.JOB.getValue());

        return jobPostService.getJobByIds(jobs.getContent(),pageNo);
    }

    public JobPostProfiles getUsersByCoordinates(Double latitude, Double longitude,
                                                Integer pageNo,Integer radius,
                                                 String type){
        double[] latLongs=calculateGeoLocDiff(latitude,longitude,radius);

        Page<UUID> users=geoLocationRepository.getObjectsByCoordinatesAndTypePerPage(latitude,longitude,pageNo,
                latLongs, type);

        //return jobPostService.getJobByIds(jobs.getContent(),pageNo);
        return null;
    }

    public JobPostProfiles getUsersByLocation(String area, String city,
                                              Integer pageNo,Integer radius,
                                              String type){
        //call google api
        double latitude=0;
        double longitude=0;
        double[] latLongs=calculateGeoLocDiff(latitude,longitude,radius);

        Page<UUID> users=geoLocationRepository.getObjectsByCoordinatesAndTypePerPage(latitude,longitude,pageNo,
                latLongs, type);

        return null;
    }


    private static double[] calculateGeoLocDiff(double latitude,double longitude,int dist){
//        Latitude: 1 deg = 110.574 km
//        Longitude: 1 deg = 111.320*cos(latitude) km   Approx
        double[] result=new double[4];
        double LAT_CONSTANT =110.574;
        double LONGI_CONSTANT=111.320;
        double latMax=latitude;
        latMax+=(latitude/ LAT_CONSTANT)*dist;
        double latMin=latitude;
        latMin-=(latitude/ LAT_CONSTANT)*dist;

        double longiMax=longitude;
        longiMax+=(longitude/ (LONGI_CONSTANT*Math.cos(latMax)))*dist;
        double longiMin=longitude;
        longiMin-=(longitude/ (LONGI_CONSTANT*Math.cos(latMin)))*dist;

        result[0]=latMax;
        result[1]=longiMax;

        result[2]=latMin;
        result[3]=longiMin;

        return result;
    }



}
