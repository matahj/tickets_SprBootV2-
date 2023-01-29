package com.bedu.tickets_sprbootv2.repository;

import com.bedu.tickets_sprbootv2.models.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DriverRepository extends CrudRepository<Driver, Long> {
}
