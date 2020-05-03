package org.alinpravariu.patientmanagement.controller;

import org.alinpravariu.patientmanagement.entity.Admin;
import org.alinpravariu.patientmanagement.factory.User;
import org.alinpravariu.patientmanagement.factory.UserFactory;
import org.alinpravariu.patientmanagement.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/patient-management")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping(path = "/add-admin")
    public @ResponseBody String addNewAdmin(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName) {

        UserFactory userFactory = new UserFactory();
        User user = userFactory.getUser("Admin");

        ((Admin) user).setUsername(username);
        ((Admin) user).setPassword(password);
        ((Admin) user).setFirstName(firstName);
        ((Admin) user).setLastName(lastName);

        adminRepository.save((Admin) user);

        return "Admin saved successfully.";
    }

    @GetMapping(path = "/all-admins")
    public @ResponseBody Iterable<Admin> getAllAdmins() {

        return adminRepository.findAll();
    }
}
