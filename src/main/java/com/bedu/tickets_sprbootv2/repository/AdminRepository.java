package com.bedu.tickets_sprbootv2.repository;

import com.bedu.tickets_sprbootv2.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
