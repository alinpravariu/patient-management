package org.alinpravariu.patientmanagement.observer;

import org.alinpravariu.patientmanagement.entity.Examination;

import java.util.ArrayList;
import java.util.List;

public class ExaminationObserver {

    private List<Observer> observers = new ArrayList<>();

    public void addObservers(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void setStatus(Examination.Status status) {
        for (Observer observer: observers) {
            observer.update(status);
        }
    }
}
