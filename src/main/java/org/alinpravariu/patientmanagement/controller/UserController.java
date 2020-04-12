package org.alinpravariu.patientmanagement.controller;

import org.alinpravariu.patientmanagement.entity.User;
import org.alinpravariu.patientmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/patient-management")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String username, @RequestParam String password, @RequestParam String firstName, @RequestParam String lastName) {

        User user = new User();

        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userRepository.save(user);

        return "User saved!";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {

        return userRepository.findAll();
    }
}
