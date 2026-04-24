package fr.eni.demo.bo.association;


import fr.eni.demo.bo.formation.Cours;
import fr.eni.demo.bo.formation.Formateur;
import fr.eni.demo.dal.CoursRepository;
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
public class TestAssoManyToMany {

    @Autowired
    private FormateurRepository formateurRepository;

    @Autowired
    private CoursRepository coursRepository;

    @BeforeEach
    void init(){

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

        List<Formateur> listeFormateurs = new ArrayList<>();

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest1")
                .prenom("PrenomTest1")
                .email("email1@gmail.com")
                .immatriculation("IMMAT1")
                .filiere("DEV")
                .build());

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest2")
                .prenom("PrenomTest2")
                .email("email2@gmail.com")
                .immatriculation("IMMAT2")
                .filiere("DEV")
                .build());

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest3")
                .prenom("PrenomTest3")
                .email("email3@gmail.com")
                .immatriculation("IMMAT3")
                .filiere("RES")
                .build());

        listeFormateurs.add(Formateur.builder()
                .nom("NomTest4")
                .prenom("PrenomTest4")
                .email("email4@gmail.com")
                .immatriculation("IMMAT4")
                .filiere("RES")
                .build());

        formateurRepository.saveAll(listeFormateurs);
    }

    @Test
    void test_save(){
        List<Formateur> listeFormateurs = formateurRepository.findAll();
        log.info(listeFormateurs.toString());
        Assertions.assertThat(listeFormateurs.size()).isEqualTo(4);

        List<Cours> listeCours = coursRepository.findAll();
        log.info(listeCours.toString());
        Assertions.assertThat(listeCours.size()).isEqualTo(4);
    }

    @Test
    void test_delete(){
        List<Formateur> listeFormateurs = formateurRepository.findAll();
        log.info(listeFormateurs.toString());
        formateurRepository.deleteById(listeFormateurs.getLast().getId());
        formateurRepository.flush();
        listeFormateurs = formateurRepository.findAll();
        log.info(listeFormateurs.toString());
        Assertions.assertThat(listeFormateurs.size()).isEqualTo(3);

        List<Cours> listeCours = coursRepository.findAll();
        log.info(listeCours.toString());
        coursRepository.deleteById(listeCours.getLast().getId());
        coursRepository.flush();
        listeCours = coursRepository.findAll();
        log.info(listeCours.toString());
        Assertions.assertThat(listeCours.size()).isEqualTo(3);
    }
}
