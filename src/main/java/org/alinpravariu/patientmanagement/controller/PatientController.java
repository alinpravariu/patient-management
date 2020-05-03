package org.alinpravariu.patientmanagement.controller;

import org.alinpravariu.patientmanagement.entity.Patient;
import org.alinpravariu.patientmanagement.factory.User;
import org.alinpravariu.patientmanagement.factory.UserFactory;
import org.alinpravariu.patientmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/patient-management")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping(path = "/add-patient")
    public @ResponseBody String addNewPatient(@RequestParam String ssn, @RequestParam String firstName, @RequestParam String lastName) {

        UserFactory userFactory = new UserFactory();
        User user = userFactory.getUser("Patient");

        ((Patient) user).setSsn(ssn);
        ((Patient) user).setFirstName(firstName);
        ((Patient) user).setLastName(lastName);

        patientRepository.save((Patient) user);

        return "Patient saved successfully.";
    }

    @GetMapping(path = "/all-patients")
    public @ResponseBody Iterable<Patient> getAllPatients() {

        return patientRepository.findAll();
    }
}
