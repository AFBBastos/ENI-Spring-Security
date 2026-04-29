package fr.eni.demo.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"immatriculation"})
@ToString
@SuperBuilder

@Entity
@Table(name = "Employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Employee_Id")
    private Integer id;

    @NotBlank
    @Size(max = 50)
    @Column(name="Employee_LastName", length = 50, nullable = false)
    private String nom;

    @NotBlank
    @Size(max = 255)
    @Column(name="Employee_FirstName", length = 50, nullable = false)
    private String prenom;

    @NotBlank
    @Size(max = 255)
    @Email
    @Column(name="Employee_Email", length = 255, nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(max = 50)
    @Column(name="Employee_Registration", length = 50, nullable = false, unique = true)
    private String immatriculation;

    @Size(max = 12)
    @Column(name="Employee_HomePhoneNumber", length = 12, nullable = true)
    private String numDom;

    @Size(max = 12)
    @Column(name="Employee_CellPhoneNumber", length = 12, nullable = true)
    private String numPortable;

    @NotNull
    //Association entre tables Employe et Adresse
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Adresse adresse;


    @ManyToOne
    @JoinColumn(name = "civility_id")
    private Civilite civilite;

}
