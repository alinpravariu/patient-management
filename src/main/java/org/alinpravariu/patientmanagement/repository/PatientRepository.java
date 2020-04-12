package org.alinpravariu.patientmanagement.repository;

import org.alinpravariu.patientmanagement.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
