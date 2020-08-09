package com.auth0.jobportal.repository.jpa;

import com.auth0.jobportal.entity.AddressEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAddressRepository extends CrudRepository<AddressEntity, UUID> {
}
