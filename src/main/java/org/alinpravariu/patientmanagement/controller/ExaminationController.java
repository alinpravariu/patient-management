package org.alinpravariu.patientmanagement.controller;

import org.alinpravariu.patientmanagement.entity.Doctor;
import org.alinpravariu.patientmanagement.entity.Examination;
import org.alinpravariu.patientmanagement.entity.Patient;
import org.alinpravariu.patientmanagement.observer.Observer;
import org.alinpravariu.patientmanagement.repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/patient-management")
public class ExaminationController {

    private List<Observer> observers;

    @Autowired
    private ExaminationRepository examinationRepository;

    public ExaminationController(List<Observer> observers) {
        this.observers = observers;
    }

    @PostMapping(path = "/add-examination")
    public @ResponseBody String addNewExamination(@RequestParam Doctor doctor, @RequestParam Patient patient, @RequestParam Examination.Status status) {

        Examination examination = new Examination();

        examination.setDoctor(doctor);
        examination.setPatient(patient);
        examination.setStatus(Examination.Status.IN_PROGRESS);

        return "Examination saved successfully.";
    }

    @GetMapping(path = "/all-examinations")
    public @ResponseBody Iterable<Examination> getAllExaminations() {

        return examinationRepository.findAll();
    }
}
