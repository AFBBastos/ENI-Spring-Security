package fr.eni.demo.bo.stagiaire;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"etudiantEni"})
@ToString(exclude = {"etudiantEni"})
@Builder

@Entity
@Table(name = "student_data")
public class DonneesPerso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "last_name", length = 50)
    private String nom;

    @Column(name = "first_name", length = 50)
    private String prenom;

    @OneToOne(mappedBy = "donneesPerso", cascade = CascadeType.ALL, orphanRemoval = true)
    private EtudiantEni etudiantEni;

}
