package com.auth0.jobportal.entity.jsonMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews implements Serializable {
    private String author;
    private String review;
    private LocalDate date;
}
