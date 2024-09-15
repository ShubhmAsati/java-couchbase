package com.auth0.jobportal.entity;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="GEO_LOCATION")
public class GeoLocationEntity extends BaseEntity{

    @Id
    @Column(name = "GEO_LOC_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID geoLocId;

//    @Column(name="GEO_COORDINATES")
//    private Point geoCoordinates;      //point_type

    //private Point coordinates;

    private Double latitude;

    private Double longitude;

    @Column(name="OBJECT_ID")
    private UUID objectID;

    @Column(name="OBJECT_TYPE")
    private String objectType;
    //Use TypeEnum


}
