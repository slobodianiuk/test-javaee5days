package ua.freesbe.test.javaee5days.day2_ejb_example.service;

import ua.freesbe.test.javaee5days.day1_jpa_example.model.Patient;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Bohdan on 1/25/2016.
 */
@Remote
public interface PatientService {
    Patient findPatientById(Long id);
    List<Patient> getAllPatients();
    void removePatient(Patient patient);
    void savePatient(Patient patient);
    public Patient merge(Patient patient);
}
