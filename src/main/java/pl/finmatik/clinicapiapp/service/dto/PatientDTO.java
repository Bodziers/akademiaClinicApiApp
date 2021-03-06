package pl.finmatik.clinicapiapp.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    private String firstName;
    private String lastName;
    @NotEmpty
    @Min(10)
    @Max(10)
    private Long pesel;
    private String phoneNumber;
    private String information;

}
