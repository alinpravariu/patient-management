package org.alinpravariu.patientmanagement.observer;

import org.alinpravariu.patientmanagement.entity.Examination;

public interface Observer {

    void update(Examination.Status status);
}
