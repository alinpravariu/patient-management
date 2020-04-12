package org.alinpravariu.patientmanagement.controller;

import org.alinpravariu.patientmanagement.entity.Examination;
import org.alinpravariu.patientmanagement.entity.Patient;
import org.alinpravariu.patientmanagement.entity.User;
import org.alinpravariu.patientmanagement.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/patient-management")
public class ExaminationController {

    @Autowired
    private ExaminationRepository examinationRepository;

    @PostMapping(path = "/add-examination")
    public @ResponseBody String addNewExamination(@RequestParam User user, @RequestParam Patient patient, @RequestParam Examination.Status status) {

        Examination examination = new Examination();

        examination.setUser(user);
        examination.setPatient(patient);
        examination.setStatus(Examination.Status.IN_PROGRESS);

        return "Examination saved successfully.";
    }

    @GetMapping(path = "/all-examinations")
    public @ResponseBody Iterable<Examination> getAllExaminations() {

        return examinationRepository.findAll();
    }
}
