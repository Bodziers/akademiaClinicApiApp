package pl.finmatik.clinicapiapp.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Id
    @Column(name = "pesel")
    private Long pesel;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "information")
    private String information;

}
