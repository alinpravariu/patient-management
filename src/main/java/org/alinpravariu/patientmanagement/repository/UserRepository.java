package org.alinpravariu.patientmanagement.repository;

import org.alinpravariu.patientmanagement.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
