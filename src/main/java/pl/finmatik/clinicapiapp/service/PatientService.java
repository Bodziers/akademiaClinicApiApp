package pl.finmatik.clinicapiapp.service.impl;

import pl.finmatik.clinicapiapp.domain.Patient;

import java.util.List;

public interface PatientService {
    public void registerPatient(Patient patient);
    public void deletePatient(String pesel);
    public void updatePatient(String pesel,Patient patient);
    public List<Patient> listPatients();
}
