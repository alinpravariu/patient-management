package org.alinpravariu.patientmanagement.factory;

import org.alinpravariu.patientmanagement.entity.Admin;
import org.alinpravariu.patientmanagement.entity.Doctor;
import org.alinpravariu.patientmanagement.entity.Patient;

public class UserFactory implements User{

    public User getUser(String userType) {
        if (userType.equalsIgnoreCase("Admin")) {
            return new Admin();
        }
        else if(userType.equalsIgnoreCase("Doctor")) {
            return new Doctor();
        }
        else if(userType.equalsIgnoreCase("Patient")) {
            return new Patient();
        }
        return null;
    }
}
