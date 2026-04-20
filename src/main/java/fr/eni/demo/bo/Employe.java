package fr.eni.demo.bo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"immatriculation"})
@ToString
@Builder
public class Employe {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String immatriculation;
    private String numDom;
    private String numPortable;


}
