package com.auth0.jobportal.repository;

import com.auth0.jobportal.entity.AddressEntity;
import com.auth0.jobportal.repository.jpa.JpaAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AddressRepository {

    private final JpaAddressRepository jpaAddressRepository;

    public AddressEntity save(AddressEntity addressEntity){return jpaAddressRepository.save(addressEntity);}
}
