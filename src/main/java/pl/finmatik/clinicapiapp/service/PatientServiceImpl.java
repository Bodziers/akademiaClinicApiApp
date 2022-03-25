package pl.finmatik.clinicapiapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.finmatik.clinicapiapp.domain.Patient;
import pl.finmatik.clinicapiapp.repository.PatientRepository;
import pl.finmatik.clinicapiapp.service.dto.PatientDTO;
import pl.finmatik.clinicapiapp.service.mapper.PatientMapper;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;
    PatientMapper patientMapper;

    //TODO check if pesel is already in base and throw exception
    @Override
    public void registerPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.patientDtoToPatient(patientDTO);
        patientRepository.save(patient);
    }

    @Override
    public void deletePatientByPesel(Long pesel) {
        patientRepository.deleteById(pesel);
    }

    @Override
    public Optional<PatientDTO> updatePatient(Long pesel, PatientDTO patientDTO) {
        return patientRepository.findById(pesel)
                .map(existingPatient -> {
                    patientMapper.updatePatient(existingPatient, patientDTO);
                    return existingPatient;
                })
                .map(patientRepository::save)
                .map(patientMapper::patientToPatientDto);
    }

    @Override
    public List<PatientDTO> listPatients() {
        return ((List<Patient>) patientRepository.findAll())
                .stream()
                .map(patientMapper::patientToPatientDto)
                .toList();
    }

    @Override
    public Optional<PatientDTO> findById(Long pesel) {
        return patientRepository.findById(pesel).map(patientMapper::patientToPatientDto);
    }

}
