package com.auth0.jobportal.entity;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="GEO_LOCATION")
public class GeoLocationEntity extends BaseEntity{

    @Id
    @Column(name = "GEO_LOC_ID")
    private UUID geoLocId;

    @Column(name="GEO_COORDINATES")
    private Point geoCoordinates;      //point_type

    @Column(name="USER_ID")
    private UUID user;

    @Column(name="USER_TYPE")
    private String userType;

    //private String latitude;

    //private String longitude;
}
