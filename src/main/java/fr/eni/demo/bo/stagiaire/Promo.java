package fr.eni.demo.bo.stagiaire;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"etudiantsEni"})
@ToString
@Builder

@Entity
@Table(name = "class_eni")
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_name", length = 20, nullable = false)
    private String nom;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private @Builder.Default List<EtudiantEni> etudiantsEni = new ArrayList<>();


}
