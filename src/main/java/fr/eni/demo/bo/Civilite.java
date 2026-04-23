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
@Table(name = "cuvility")
public class Civilite {

    @Id
    @Column(name = "civility_id", nullable = false, length = 5)
    private String cle; // M, ou MME, ou MLLE

    @Column(name = "civility_label", nullable = false, length = 20)
    private String libelle;

}
