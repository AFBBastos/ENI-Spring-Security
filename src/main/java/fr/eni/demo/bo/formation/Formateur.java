package fr.eni.demo.bo.formation;

import fr.eni.demo.bo.Employe;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder

@Entity
@Table(name = "trainer")
public class Formateur extends Employe {

    @Column(name = "computer_science_course", length = 100, nullable = false)
    private String filiere;

    @ManyToMany
    @JoinTable(name = "computer_course_provided",
            joinColumns = {
                @JoinColumn(name = "trainer_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "computer_course_id")}
    )
    @Builder.Default
    private List<Cours> listeCours = new ArrayList<>();

}
