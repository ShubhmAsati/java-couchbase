package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.GeoLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaGeoLocationRepository extends JpaRepository<GeoLocationEntity, UUID> {

}
