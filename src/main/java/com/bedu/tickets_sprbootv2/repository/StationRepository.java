package com.bedu.tickets_sprbootv2.repository;

import com.bedu.tickets_sprbootv2.models.Station;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StationRepository extends CrudRepository<Station, Long> {
}
