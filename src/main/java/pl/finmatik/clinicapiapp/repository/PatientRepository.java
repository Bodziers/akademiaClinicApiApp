package pl.finmatik.clinicapiapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.finmatik.clinicapiapp.domain.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {}
