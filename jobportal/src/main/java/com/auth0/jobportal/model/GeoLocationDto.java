package com.auth0.jobportal.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.geo.Point;

@Data
@Builder
public class GeoLocationDto {

  private UUID geoLocId;

  private Point coordinates;      //point_type

  private UUID objectId;

  private String objectType;


//  private String latitude;
//
//  private String longitude;

}
