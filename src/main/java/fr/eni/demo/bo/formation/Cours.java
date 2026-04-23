package fr.eni.demo.bo.formation;

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
@Table(name = "computer_course")
public class Cours {

    @Id
    @Column(name = "computer_course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reference", nullable = false, length = 20, unique = true)
    private String reference;

    @Column(name = "title", nullable = false, length = 50, unique = true)
    private String titre;

    @Column(name = "computer_science_course", nullable = false, length = 50)
    private String filiere;


}
