package fr.eni.demo.bo;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"immatriculation"})
@ToString
@Builder

@Entity
@Table(name = "Employee")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Employee_Id")
    private Integer id;

    @Column(name="Employee_LastName", length = 50, nullable = false)
    private String nom;

    @Column(name="Employee_FirstName", length = 50, nullable = false)
    private String prenom;

    @Column(name="Employee_Email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name="Employee_Registration", length = 50, nullable = false, unique = true)
    private String immatriculation;

    @Column(name="Employee_HomePhoneNumber", length = 12, nullable = true)
    private String numDom;

    @Column(name="Employee_CellPhoneNumber", length = 12, nullable = true)
    private String numPortable;

    //Association entre tables Employe et Adresse
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Adresse adresse;

}
