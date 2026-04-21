package fr.eni.demo.bo;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "address")
public class Adresse {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name ="address_id")
    private Integer id;


    @Column(name ="address_street", length = 100, nullable = false)
    private String rue;


    @Column(name ="address_postalcode", length = 50, nullable = false)
    private String codePostal;


    @Column(name ="address_city", length = 50, nullable = false)
    private String ville;




}
