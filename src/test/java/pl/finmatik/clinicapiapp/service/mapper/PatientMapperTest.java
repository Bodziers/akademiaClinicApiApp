package pl.finmatik.clinicapiapp.service.mapper;

import org.junit.jupiter.api.Test;
import pl.finmatik.clinicapiapp.domain.Patient;
import pl.finmatik.clinicapiapp.service.dto.PatientDTO;
import pl.finmatik.clinicapiapp.service.dto.PatientGetDTO;

import static org.junit.jupiter.api.Assertions.*;

class PatientMapperTest {

    //initial patient data
    private final Long testId = 1L;
    private final String firstTestName = "Eve";
    private final String lastTestName = "Smith";
    private final Long testPesel = 1234567890L;
    private final String testPhoneNumber = "666666666";
    private final String testInformation = "some additional info";

    @Test
    void should_map_patientDto_To_Patient() {
        //given
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFirstName(firstTestName);
        patientDTO.setLastName(lastTestName);
        patientDTO.setPesel(testPesel);
        patientDTO.setPhoneNumber(testPhoneNumber);
        patientDTO.setInformation(testInformation);
        //when
        Patient patient = PatientMapper.INSTANCE.patientDtoToPatient(patientDTO);
        //then
        assertEquals(firstTestName,patient.getFirstName());
        assertEquals(lastTestName,patient.getLastName());
        assertEquals(testPesel, patient.getPesel());
        assertEquals(testPhoneNumber, patient.getPhoneNumber());
        assertEquals(testInformation, patient.getInformation());
    }

    @Test
    void should_map_patient_To_PatientDto() {
        //given
        Patient patient = new Patient(testId,firstTestName,lastTestName,testPesel,testPhoneNumber,testInformation);
        //when
        PatientDTO patientDTO = PatientMapper.INSTANCE.patientToPatientDto(patient);
        //then
        assertEquals(firstTestName, patientDTO.getFirstName());
        assertEquals(lastTestName,patientDTO.getLastName());
        assertEquals(testPesel, patientDTO.getPesel());
        assertEquals(testPhoneNumber, patientDTO.getPhoneNumber());
        assertEquals(testInformation, patientDTO.getInformation());
    }
    @Test
    void should_map_slim_patient_To_PatientDto() {
        //given
        Patient patient = new Patient(testId,firstTestName,lastTestName,testPesel,testPhoneNumber,testInformation);
        //when
        PatientGetDTO patientSlimDTO = PatientMapper.INSTANCE.patientGetToDTO(patient);
        //then
        assertEquals(firstTestName, patientSlimDTO.getFirstName());
        assertEquals(lastTestName,patientSlimDTO.getLastName());
        assertEquals(testPesel, patientSlimDTO.getPesel());
        assertEquals(testPhoneNumber, patientSlimDTO.getPhoneNumber());
    }

}
