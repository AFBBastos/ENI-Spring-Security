package fr.eni.demo.bo.pk;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class EtudiantPK implements Serializable {

    private String email;
    private String immatriculation;

}
