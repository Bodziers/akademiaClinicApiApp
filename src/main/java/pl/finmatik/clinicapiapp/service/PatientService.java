package pl.finmatik.clinicapiapp.service;

import pl.finmatik.clinicapiapp.service.dto.PatientDTO;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    public void registerPatient(PatientDTO patientDTO);
    public void deletePatientByPesel(Long pesel);
    public Optional<PatientDTO> updatePatient(Long pesel, PatientDTO patientDTO);
    public List<PatientDTO> listPatients();
    public Optional<PatientDTO> findById(Long pesel);
}
