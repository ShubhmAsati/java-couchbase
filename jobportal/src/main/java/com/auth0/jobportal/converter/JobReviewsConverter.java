package com.auth0.jobportal.converter;

import com.auth0.jobportal.entity.JobReviewsEntity;
import com.auth0.jobportal.model.JobReviewsDto;

public class JobReviewsConverter {

    public static JobReviewsEntity reviewsDtoToEntity(JobReviewsDto jobReviewsDto){
        return JobReviewsEntity.builder()
                .jobId(jobReviewsDto.getJobId())
                .reviews(jobReviewsDto.getReviews())
                .build();
    }

    public static JobReviewsDto reviewsEntityToDto(JobReviewsEntity jobReviewsEntity){
        return JobReviewsDto.builder()
                .jobId(jobReviewsEntity.getJobId())
                .reviews(jobReviewsEntity.getReviews())
                .build();
    }
}
