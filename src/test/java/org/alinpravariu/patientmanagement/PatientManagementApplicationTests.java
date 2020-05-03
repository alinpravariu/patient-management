package org.alinpravariu.patientmanagement;

import org.alinpravariu.patientmanagement.entity.Doctor;
import org.alinpravariu.patientmanagement.entity.Examination;
import org.alinpravariu.patientmanagement.entity.Patient;
import org.alinpravariu.patientmanagement.repository.DoctorRepository;
import org.alinpravariu.patientmanagement.repository.ExaminationRepository;
import org.alinpravariu.patientmanagement.repository.PatientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PatientManagementApplicationTests {

	@Mock
	private DoctorRepository mockDoctorRepository;
	@Mock
	private PatientRepository mockPatientRepository;
	@Mock
	private ExaminationRepository mockExaminationRepository;

	private Doctor doctor;
	private Patient patient;
	private Examination examination;

	@BeforeAll
	public void setup() {
		doctor = new Doctor();

		doctor.setId(1);
		doctor.setUsername("alinpravariu");
		doctor.setPassword("test");
		doctor.setFirstName("Alin");
		doctor.setLastName("Pravariu");

		patient = new Patient();

		patient.setId(1);
		patient.setSsn("1800612324845");
		patient.setFirstName("Ion");
		patient.setLastName("Popescu");

		examination = new Examination();

		examination.setId(1);
		examination.setDoctor(doctor);
		examination.setPatient(patient);
		examination.setStatus(Examination.Status.IN_PROGRESS);
	}

	@Test
	public void testAddUser() {
		final String username = "alinpravariu";

		Doctor result = mockDoctorRepository.save(doctor);

		assert(result.getUsername().equals(username));
	}

	@Test
	public void testAddPatient() {
		final String ssn = "1800612324845";

		Patient result = mockPatientRepository.save(patient);

		assert(result.getSsn().equals(ssn));
	}

	@Test
	public void testAddExamination() {
		final String username = "alinpravariu";

		Examination result = mockExaminationRepository.save(examination);

		assert(result.getDoctor().getUsername().equals(username));
	}

}
