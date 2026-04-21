package fr.eni.demo.bo.stagiaire;


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
@Table(name = "eni_student")
public class EtudiantEni {

    @Id
    @Column(name = "student_registration", length = 20, nullable = false)
    private String immatriculation;

    @Column(name = "student_email", length = 100, nullable = false)
    private String email;

    //L'attribut ci-dessous a été choisi comme classe prioritaire par rapport à donnesPerso
    //On voit que les annotation sur l'attribut sont différentes dans les deux classes
    //Il faut penser à exclure l'attribut "etudiantEni" dans les annotations pour valider les tests.
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "data_id")
    private DonneesPerso donneesPerso;

}