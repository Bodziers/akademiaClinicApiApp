package pl.finmatik.clinicapiapp.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientGetDTO {

    private String firstName;
    private String lastName;
    private Long pesel;
    private String phoneNumber;
}
