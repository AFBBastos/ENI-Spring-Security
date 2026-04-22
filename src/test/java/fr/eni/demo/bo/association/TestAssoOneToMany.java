package fr.eni.demo.bo.association;

import fr.eni.demo.bo.stagiaire.DonneesPerso;
import fr.eni.demo.bo.stagiaire.EtudiantEni;
import fr.eni.demo.bo.stagiaire.Promo;
import fr.eni.demo.dal.PromoRepository;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
@Slf4j
public class TestAssoOneToMany {

    @Autowired
    private PromoRepository promoRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void test_save(){

        Promo promo = Promo
                .builder()
                .nom("test_01")
                .build();

        for (int i = 0; i < 5; i++){

            DonneesPerso donneesPerso = DonneesPerso
                    .builder()
                    .nom("Nom" + i)
                    .prenom("Prenom" + i)
                    .build();

            EtudiantEni etudiantEni = EtudiantEni
                    .builder()
                    .email("email" + i + "@gmail.com")
                    .immatriculation("IMMAT0" + i)
                    .build();

            promo.getEtudiantsEni().add(etudiantEni);
        }

        Promo promoDB = promoRepository.save(promo);

        log.info(promoDB.toString());

        Assertions.assertThat(promoDB.getId()).isGreaterThan(0);
        Assertions.assertThat(promoDB.getEtudiantsEni().size()).isEqualTo(5);
    }

    @Test
    void test_deletePromo(){
        Promo promo = Promo
                .builder()
                .nom("PromoTest_01")
                .build();

        for (int i = 0; i <5; i++){
            EtudiantEni etudiantEni = EtudiantEni
                    .builder()
                    .email("emailTest" + i + "@gmail.com")
                    .immatriculation("ImmatTest" + i)
                    .build();

            promo.getEtudiantsEni().add(etudiantEni);
        }

        entityManager.persist(promo);
        entityManager.flush();

        log.info(promo.toString());

        Integer promoId = promo.getId();
        promoRepository.delete(promo);

        Promo promoDB = entityManager.find(Promo.class, promoId);

        Assertions.assertThat(promoDB).isNull();

        for(int i = 0; i <5 ; i++){
            EtudiantEni etudiantEniDB = entityManager.find(EtudiantEni.class, "ImmatTest"+i);
            Assertions.assertThat(etudiantEniDB).isNull();
        }

    }

    @Test
    void test_orphanRemoval(){
        Promo promo = Promo
                .builder()
                .nom("PromoTest_01")
                .build();

        for (int i = 0; i <5; i++){
            EtudiantEni etudiantEni = EtudiantEni
                    .builder()
                    .email("emailTest" + i + "@gmail.com")
                    .immatriculation("ImmatTest" + i)
                    .build();

            promo.getEtudiantsEni().add(etudiantEni);
        }

        entityManager.persist(promo);
        entityManager.flush();

        log.info(promo.toString());

        Integer promoId = promo.getId();

        promo.getEtudiantsEni().clear();

        promoRepository.delete(promo);

        Promo promoDB = entityManager.find(Promo.class, promoId);

        Assertions.assertThat(promoDB).isNull();

        for(int i = 0; i <5 ; i++){
            EtudiantEni etudiantEniDB = entityManager.find(EtudiantEni.class, "ImmatTest"+i);
            Assertions.assertThat(etudiantEniDB).isNull();
        }

    }



}
