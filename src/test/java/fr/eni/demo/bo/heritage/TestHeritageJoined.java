package fr.eni.demo.bo.heritage;


import fr.eni.demo.bo.ChargeRee;
import fr.eni.demo.bo.Employe;
import fr.eni.demo.bo.formation.Formateur;
import fr.eni.demo.dal.ChargeeReeRepository;
import fr.eni.demo.dal.EmployeRepository;
import fr.eni.demo.dal.FormateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@Slf4j
public class TestHeritageJoined {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private ChargeeReeRepository chargeeReeRepository;

    @BeforeEach
    void init(){

        List<Employe> listeEmploye = new ArrayList<>();

        listeEmploye.add(Employe
                .builder()
                .nom("NomTest1")
                .prenom("PrenomTest1")
                .immatriculation("IMMAT1")
                .email("email1@gmail.com")
                .build());

        listeEmploye.add(Formateur
                .builder()
                .nom("NomTest2")
                .prenom("PrenomTest2")
                .immatriculation("IMMAT2")
                .email("email2@gmail.com")
                .filiere("DEV")
                .build());

        listeEmploye.add(ChargeRee
                .builder()
                .nom("NomTest3")
                .prenom("PrenomTest3")
                .immatriculation("IMMAT3")
                .email("email3@gmail.com")
                .numeroBureau("BUR1")
                .build());

        employeRepository.saveAll(listeEmploye);
    }

    @Test
    void test_findAll(){

        List<Employe> employeList = employeRepository.findAll();

        log.info(employeList.toString());

        Assertions.assertThat(employeList).hasSize(3);

    }

    @Test
    void test_findAllFormateur(){
        List<Formateur> formateurList = formateurRepository.findAll();

        log.info(formateurList.toString());

        Assertions.assertThat(formateurList).hasSize(1);

    }

}
