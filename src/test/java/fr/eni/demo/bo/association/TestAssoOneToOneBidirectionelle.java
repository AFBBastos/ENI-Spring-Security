package fr.eni.demo.bo.association;

import fr.eni.demo.bo.stagiaire.DonneesPerso;
import fr.eni.demo.bo.stagiaire.EtudiantEni;
import fr.eni.demo.dal.DonneesPersoRepository;
import fr.eni.demo.dal.EtudiantEniRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
@Slf4j
public class TestAssoOneToOneBidirectionelle {

    @Autowired
    private EtudiantEniRepository etudiantEniRepository;

    @Autowired
    private DonneesPersoRepository donneesPersoRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void test_save_etudiantEni() {
        EtudiantEni etudiantEni = EtudiantEni
                .builder()
                .email("email1@email.com")
                .immatriculation("IMMAT1")
                .build();

        DonneesPerso donneesPerso = DonneesPerso
                .builder()
                .nom("NomTest")
                .prenom("PrenomTest")
                .build();

        etudiantEni.setDonneesPerso(donneesPerso);
        donneesPerso.setEtudiantEni(etudiantEni);

        EtudiantEni etudiantEniDB = etudiantEniRepository.save(etudiantEni);
        log.info(etudiantEniDB.toString());

        Assertions.assertThat(etudiantEniDB.getDonneesPerso().getId()).isNotNull();

    }

    @Test
    void test_save_donneesPerso() {
        EtudiantEni etudiantEni = EtudiantEni
                .builder()
                .email("email1@email.com")
                .immatriculation("IMMAT1")
                .build();

        DonneesPerso donneesPerso = DonneesPerso
                .builder()
                .nom("NomTest")
                .prenom("PrenomTest")
                .build();

        etudiantEni.setDonneesPerso(donneesPerso);
        donneesPerso.setEtudiantEni(etudiantEni);

        DonneesPerso donneesPersoDB = donneesPersoRepository.save(donneesPerso);
        log.info(donneesPersoDB.toString());

        Assertions.assertThat(donneesPersoDB.getId()).isGreaterThan(0);


       EtudiantEni etudiantEniDB = entityManager.find(EtudiantEni.class, "IMMAT1");

        Assertions.assertThat(etudiantEniDB).isNotNull();

    }

    @Test
    void test_delete_etudiantEni() {
        EtudiantEni etudiantEni = EtudiantEni
                .builder()
                .email("email1@email.com")
                .immatriculation("IMMAT1")
                .build();

        DonneesPerso donneesPerso = DonneesPerso
                .builder()
                .nom("NomTest")
                .prenom("PrenomTest")
                .build();

        etudiantEni.setDonneesPerso(donneesPerso);
        donneesPerso.setEtudiantEni(etudiantEni);

        entityManager.persist(etudiantEni);
        entityManager.flush();

        log.info(etudiantEni.toString());

        Integer idDonneesPerso = etudiantEni.getDonneesPerso().getId();

        etudiantEniRepository.delete(etudiantEni);

        EtudiantEni etudiantEniDB = entityManager.find(EtudiantEni.class, "IMMAT1");

        Assertions.assertThat(etudiantEniDB).isNull();

        DonneesPerso donneesPersoDB = entityManager.find(DonneesPerso.class, idDonneesPerso);

        Assertions.assertThat(donneesPersoDB).isNull();
    }

    @Test
    void test_delete_donnesPerso() {
        EtudiantEni etudiantEni = EtudiantEni
                .builder()
                .email("email1@email.com")
                .immatriculation("IMMAT1")
                .build();

        DonneesPerso donneesPerso = DonneesPerso
                .builder()
                .nom("NomTest")
                .prenom("PrenomTest")
                .build();

        etudiantEni.setDonneesPerso(donneesPerso);
        donneesPerso.setEtudiantEni(etudiantEni);

        entityManager.persist(etudiantEni);
        entityManager.flush();

        log.info(etudiantEni.toString());

        Integer idDonneesPerso = etudiantEni.getDonneesPerso().getId();

        donneesPersoRepository.delete(donneesPerso);

        EtudiantEni etudiantEniDB = entityManager.find(EtudiantEni.class, "IMMAT1");

        Assertions.assertThat(etudiantEniDB).isNull();

        DonneesPerso donneesPersoDB = entityManager.find(DonneesPerso.class, idDonneesPerso);

        Assertions.assertThat(donneesPersoDB).isNull();
    }

    @Test
    void test_orphanRemovalEtudiantEni() {
        EtudiantEni etudiantEni = EtudiantEni
                .builder()
                .email("email1@email.com")
                .immatriculation("IMMAT1")
                .build();

        DonneesPerso donneesPerso = DonneesPerso
                .builder()
                .nom("NomTest")
                .prenom("PrenomTest")
                .build();

        etudiantEni.setDonneesPerso(donneesPerso);
        donneesPerso.setEtudiantEni(etudiantEni);

        entityManager.persist(etudiantEni);
        entityManager.flush();

        log.info(etudiantEni.toString());

        Integer idDonneesPerso = etudiantEni.getDonneesPerso().getId();

        etudiantEni.setDonneesPerso(null);

        etudiantEniRepository.delete(etudiantEni);

        EtudiantEni etudiantEniDB = entityManager.find(EtudiantEni.class, "IMMAT1");

        Assertions.assertThat(etudiantEniDB).isNull();

        DonneesPerso donneesPersoDB = entityManager.find(DonneesPerso.class, idDonneesPerso);

        Assertions.assertThat(donneesPersoDB).isNull();
    }

    @Test
    void test_orphanRemovalDonnesPerso() {
        EtudiantEni etudiantEni = EtudiantEni
                .builder()
                .email("email1@email.com")
                .immatriculation("IMMAT1")
                .build();

        DonneesPerso donneesPerso = DonneesPerso
                .builder()
                .nom("NomTest")
                .prenom("PrenomTest")
                .build();

        etudiantEni.setDonneesPerso(donneesPerso);
        donneesPerso.setEtudiantEni(etudiantEni);

        entityManager.persist(etudiantEni);
        entityManager.flush();

        log.info(etudiantEni.toString());

        Integer idDonneesPerso = etudiantEni.getDonneesPerso().getId();

        donneesPerso.setEtudiantEni(null);

        donneesPersoRepository.delete(donneesPerso);

        EtudiantEni etudiantEniDB = entityManager.find(EtudiantEni.class, "IMMAT1");

        Assertions.assertThat(etudiantEniDB).isNull();

        DonneesPerso donneesPersoDB = entityManager.find(DonneesPerso.class, idDonneesPerso);

        Assertions.assertThat(donneesPersoDB).isNull();
    }



}
