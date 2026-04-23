package fr.eni.demo.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder

@Entity
@Table(name = "school_business_officer")
public class ChargeRee extends Employe{

    @Column(name = "office_number", length = 10)
    private String numeroBureau;


}
