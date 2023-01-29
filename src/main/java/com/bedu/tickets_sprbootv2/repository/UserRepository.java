package com.bedu.tickets_sprbootv2.repository;

import com.bedu.tickets_sprbootv2.models.User;
import jakarta.validation.Valid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
}
