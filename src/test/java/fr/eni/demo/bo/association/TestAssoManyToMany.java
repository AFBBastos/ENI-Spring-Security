package fr.eni.demo.bo.association;


import fr.eni.demo.bo.formation.Cours;
import fr.eni.demo.bo.formation.Formateur;
import fr.eni.demo.dal.CoursRepository;
import fr.eni.demo.dal.FormateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@Slf4j
public class TestAssoManyToMany {

    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private CoursRepository coursRepository;

    private Cours java;
    private Cours spring;
    private Cours python;
    private Cours basesDesReseaux;

    private Formateur formateur1;
    private Formateur formateur2;
    private Formateur formateur3;
    private Formateur formateur4;

    @BeforeEach
    void init_cours(){

        List<Cours> listeCours = new ArrayList<>();

        listeCours.add(Cours.builder()
                .titre("Java POO")
                .filiere("DEV")
                .reference("DEV2026_01")
                .build());

        listeCours.add(Cours.builder()
                .titre("Spring Boot")
                .filiere("DEV")
                .reference("DEV2026_02")
                .build());

        listeCours.add(Cours.builder()
                .titre("Python")
                .filiere("DEV")
                .reference("DEV2026_03")
                .build());

        listeCours.add(Cours.builder()
                .titre("Réseau")
                .filiere("RESEAU")
                .reference("RES2026_01")
                .build());

        coursRepository.saveAll(listeCours);
    }

    @BeforeEach
    void _init_formateur(){

        List<Formateur> listeFormateurs = new ArrayList<>();

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest1")
                .prenom("PrenomTest1")
                .filiere("DEV")
                .build());

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest2")
                .prenom("PrenomTest2")
                .filiere("DEV")
                .build());

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest3")
                .prenom("PrenomTest3")
                .filiere("RES")
                .build());

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest4")
                .prenom("PrenomTest4")
                .filiere("RES")
                .build());

        formateurRepository.saveAll(listeFormateurs);
    }

    //TODO: Corriger le test ci-dessous
    // pour vérifier la bonne implementation du code
//    @Test
//    void test_save(){
//
//
//        log.info(listeCours.toString());
//        Assertions.assertThat(formateurDB.isPresent()).isTrue();
//        Assertions.assertThat(formateurDB4.getListeCours()).hasSize(3);
//    }

//    @Test
//    void test_delete(){
//
//    }

}
