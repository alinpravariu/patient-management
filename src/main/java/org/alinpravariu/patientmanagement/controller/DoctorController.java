package org.alinpravariu.patientmanagement.controller;

import org.alinpravariu.patientmanagement.entity.Doctor;
import org.alinpravariu.patientmanagement.factory.User;
import org.alinpravariu.patientmanagement.factory.UserFactory;
import org.alinpravariu.patientmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/patient-management")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping(path = "/add-doctor")
    public @ResponseBody
    String addNewDoctor(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName) {

        UserFactory userFactory = new UserFactory();
        User user = userFactory.getUser("Doctor");

        ((Doctor) user).setUsername(username);
        ((Doctor) user).setPassword(password);
        ((Doctor) user).setFirstName(firstName);
        ((Doctor) user).setLastName(lastName);

        doctorRepository.save((Doctor) user);

        return "Doctor saved successfully.";
    }

    @GetMapping(path = "/all-doctors")
    public @ResponseBody Iterable<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }
}
