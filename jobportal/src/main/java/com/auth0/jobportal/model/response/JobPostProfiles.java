package com.auth0.jobportal.model.response;

import com.auth0.jobportal.model.JobPostProfileDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobPostProfiles {
    Iterable<JobPostProfileDto> currentProfiles;
    Iterable<JobPostProfileDto> nextProfiles;
    Iterable<JobPostProfileDto> prevProfiles;
    //int totalPages;
}
