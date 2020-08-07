package com.auth0.jobportal.repository;

import com.auth0.jobportal.constants.ApplicationConstants;
import com.auth0.jobportal.repository.jpa.JpaGeoLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class GeoLocationRepository {

    private final JpaGeoLocationRepository jpaGeoLocationRepository;

    public Page<UUID> getObjectsByCoordinatesAndTypePerPage(Double latitude, Double longitude,
                                                            Integer pageNo, double[] latLongs, String type){

         return jpaGeoLocationRepository.getObjectsByCoordinatesAndTypePerPage
                (latitude,longitude,latLongs[0],latLongs[1],latLongs[2],latLongs[3],type,
                        PageRequest.of(pageNo, ApplicationConstants.JOBS_PER_PAGE));

    }



}

//    CREATE OR REPLACE FUNCTION calculate_distance(lat1 float, lon1 float, lat2 float, lon2 float, units varchar)
//RETURNS float AS $dist$
//        DECLARE
//        dist float = 0;
//        radlat1 float;
//        radlat2 float;
//        theta float;
//        radtheta float;
//        BEGIN
//        IF lat1 = lat2 OR lon1 = lon2
//        THEN RETURN dist;
//        ELSE
//        radlat1 = pi() * lat1 / 180;
//        radlat2 = pi() * lat2 / 180;
//        theta = lon1 - lon2;
//        radtheta = pi() * theta / 180;
//        dist = sin(radlat1) * sin(radlat2) + cos(radlat1) * cos(radlat2) * cos(radtheta);
//
//        IF dist > 1 THEN dist = 1; END IF;
//
//        dist = acos(dist);
//        dist = dist * 180 / pi();
//        dist = dist * 60 * 1.1515;
//
//        IF units = 'K' THEN dist = dist * 1.609344; END IF;
//        IF units = 'N' THEN dist = dist * 0.8684; END IF;
//
//        RETURN dist;
//        END IF;
//        END;
//        $dist$ LANGUAGE plpgsql;
