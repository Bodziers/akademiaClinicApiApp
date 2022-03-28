package pl.finmatik.clinicapiapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.finmatik.clinicapiapp.service.PatientService;
import pl.finmatik.clinicapiapp.service.dto.PatientDTO;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        return ResponseEntity.status(HttpStatus.OK).body(this.patientService.listPatients());
    }


    @GetMapping("/{pesel}")
    public ResponseEntity<PatientDTO> findByPesel(@PathVariable(value="pesel") final Long pesel) {
        PatientDTO patientDTO = patientService.findById(pesel).orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }

    @DeleteMapping("/{pesel}")
    public ResponseEntity<Void> deletePatientByPesel(@PathVariable(value="pesel") final Long pesel) {
        this.patientService.deletePatientByPesel(pesel);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<Void> registerPatient(@RequestBody @Valid PatientDTO patientDTO) {
        patientService.registerPatient(patientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{pesel}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable(value="pesel") final Long pesel, @RequestBody @Valid PatientDTO patientDTO) {
        patientService.updatePatient(pesel, patientDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
