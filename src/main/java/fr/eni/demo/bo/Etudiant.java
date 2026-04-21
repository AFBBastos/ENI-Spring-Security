package fr.eni.demo.bo;

import fr.eni.demo.bo.pk.EtudiantPK;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder

@Entity
@Table(name = "Student")
@IdClass(EtudiantPK.class)
public class Etudiant {

    @Id
    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Id
    @Column(name ="Student_Registration", length = 12, nullable = false, unique = true)
    private String immatriculation;

    @Column(name ="Last_Name", length = 50, nullable = false)
    private String nom;

    @Column(name ="First_Name", length = 50, nullable = false)
    private String prenom;


}
