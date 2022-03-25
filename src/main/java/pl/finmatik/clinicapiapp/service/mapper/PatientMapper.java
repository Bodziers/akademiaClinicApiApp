package pl.finmatik.clinicapiapp.service.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.finmatik.clinicapiapp.domain.Patient;
import pl.finmatik.clinicapiapp.service.dto.PatientDTO;
import pl.finmatik.clinicapiapp.service.dto.PatientGetDTO;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper( PatientMapper.class );
    Patient patientDtoToPatient(PatientDTO patient);
    PatientDTO patientToPatientDto(Patient patient);
    PatientGetDTO patientGetToDTO(Patient patient);

    //additional mapper for update
    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePatient(@MappingTarget Patient patient, PatientDTO patientDTO);
}
