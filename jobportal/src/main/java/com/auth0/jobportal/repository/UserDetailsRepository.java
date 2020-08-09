package com.auth0.jobportal.repository;

import com.auth0.jobportal.entity.UserDetailsEntity;
import com.auth0.jobportal.repository.jpa.JpaUserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDetailsRepository {

    private final JpaUserDetailsRepository jpaUserDetailsRepository;

    public UserDetailsEntity save(UserDetailsEntity userDetailsEntity)
    {return jpaUserDetailsRepository.save(userDetailsEntity);}

}
