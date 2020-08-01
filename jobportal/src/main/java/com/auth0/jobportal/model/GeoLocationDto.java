package com.auth0.jobportal.model;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoLocationDto {

  private UUID geoLocationId;

  private String latitude;

  private String longitude;

}
