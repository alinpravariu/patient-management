package org.alinpravariu.patientmanagement.repository;

import org.alinpravariu.patientmanagement.entity.Examination;
import org.springframework.data.repository.CrudRepository;

public interface ExaminationRepository extends CrudRepository<Examination, Integer> {
}
