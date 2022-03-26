package pl.finmatik.clinicapiapp.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.finmatik.clinicapiapp.domain.Patient;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PatientRepositoryTest {

        @Autowired
        private TestEntityManager entityManager;
        @Autowired
        private PatientRepository patientRepository;

        private Patient patient;

        @BeforeEach
        public void setUp() {
           patient = new Patient(1L,"Adam","Nowak",1111111111L, "123 444 555", "info");
        }

        @AfterEach
        public void tearDown() {
            patientRepository.deleteAll();
            patient = null;
        }

        @Test
        void should_register_patient() {
            //given
            entityManager.persist(patient);
            patientRepository.save(new Patient(2L,"Ewa","Nowak",1111111112L, "123 444 555", "info"));
            //when
            Optional<Patient> patient = patientRepository.findById(1111111112L);
            //then
            assertThat(patient).isPresent();
        }

        @Test
        void should_delete_patient_by_pesel() {
            //given
            entityManager.persist(patient);
            //when
            patientRepository.deleteById(1111111111L);
            //then
            assertThat(patientRepository.findById(1111111111L)).isEmpty();
        }

        @Test
        void should_find_patient_by_id() {
            //given
            entityManager.persist(patient);
            //when
            Optional<Patient> patient = patientRepository.findById(1111111111L);
            //then
            assertThat(patient).isPresent();
        }

        @Test
        void should_get_all_patients() {
            //given
            Long numberOfPatient = patientRepository.count();
            entityManager.persist(patient);
            patientRepository.save(new Patient(2L,"Ewa","Nowak",1111111112L, "123 444 555", "info"));
            //when
            List<Patient> patientList = (List<Patient>) patientRepository.findAll();
            //then
            assertThat(patientList).isNotNull();
            assertThat(numberOfPatient+2).isEqualTo(patientList.size());
        }
}

