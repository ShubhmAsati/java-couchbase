package com.auth0.jobportal.repository;

import com.auth0.jobportal.repository.jpa.JpaGeoLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GeoLocationRepository {

    private final JpaGeoLocationRepository jpaGeoLocationRepository;





}
