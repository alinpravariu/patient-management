package org.alinpravariu.patientmanagement.repository;

import org.alinpravariu.patientmanagement.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
