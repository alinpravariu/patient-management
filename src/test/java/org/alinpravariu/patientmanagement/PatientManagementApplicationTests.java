package org.alinpravariu.patientmanagement;

import org.alinpravariu.patientmanagement.entity.Examination;
import org.alinpravariu.patientmanagement.entity.Patient;
import org.alinpravariu.patientmanagement.entity.User;
import org.alinpravariu.patientmanagement.repository.ExaminationRepository;
import org.alinpravariu.patientmanagement.repository.PatientRepository;
import org.alinpravariu.patientmanagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PatientManagementApplicationTests {

	@Mock
	private UserRepository mockUserRepository;
	@Mock
	private PatientRepository mockPatientRepository;
	@Mock
	private ExaminationRepository mockExaminationRepository;

	private User user;
	private Patient patient;
	private Examination examination;

	@BeforeAll
	public void setup() {
		user = new User();

		user.setId(1);
		user.setUsername("alinpravariu");
		user.setPassword("test");
		user.setFirstName("Alin");
		user.setLastName("Pravariu");

		patient = new Patient();

		patient.setId(1);
		patient.setSsn("1800612324845");
		patient.setFirstName("Ion");
		patient.setLastName("Popescu");

		examination = new Examination();

		examination.setId(1);
		examination.setUser(user);
		examination.setPatient(patient);
		examination.setStatus(Examination.Status.IN_PROGRESS);
	}

	@Test
	public void testAddUser() {
		final String username = "alinpravariu";

		User result = mockUserRepository.save(user);

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

		assert(result.getUser().getUsername().equals(username));
	}

}
