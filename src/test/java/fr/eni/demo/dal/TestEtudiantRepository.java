package fr.eni.demo.dal;

import fr.eni.demo.bo.Etudiant;
import fr.eni.demo.bo.pk.EtudiantPK;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@Slf4j
public class TestEtudiantRepository {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void test_save() {
        Etudiant etudiant = Etudiant
                .builder()
                .email("email1@gmail.com")
                .immatriculation("IMMAT1")
                .nom("NomTest1")
                .prenom("PrenomTest1")
                .build();

        Etudiant etudiantDB = etudiantRepository.save(etudiant);

        Assertions.assertNotNull(etudiantDB);

        log.info(etudiantDB.toString());
    }

    @Test
    void test_find() {
        Etudiant etudiant = Etudiant
                .builder()
                .email("email2@gmail.com")
                .immatriculation("IMMAT2")
                .nom("NomTest2")
                .prenom("PrenomTest2")
                .build();

        entityManager.persist(etudiant);
        entityManager.flush();

        EtudiantPK id = EtudiantPK
                .builder()
                .email("email2@gmail.com")
                .immatriculation("IMMAT2")
                .build();

        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);

        org.assertj.core.api.Assertions.assertThat(optionalEtudiant.isPresent()).isTrue();

        log.info(optionalEtudiant.get().toString());

    }





}
