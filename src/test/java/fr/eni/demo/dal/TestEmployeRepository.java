package fr.eni.demo.dal;

import fr.eni.demo.bo.Employe;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@Slf4j
public class TestEmployeRepository {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void test_saveEmploye(){
        Employe employe = Employe.builder()
                .email("email@email.com")
                .nom("NomTest1")
                .prenom("PrenomTest1")
                .immatriculation("TESTIMMAT1")
                .numDom("02134567890")
                .numPortable("0689123456")
                .build();

        Employe employeDB = employeRepository.save(employe);

        log.info(employeDB.toString());

        Assertions.assertThat(employeDB.getId()).isGreaterThan(0);
    }

    @Test
    public void test_findEmploye() {
        Employe employe = Employe.builder()
                .email("email@email.com")
                .nom("NomTest1")
                .prenom("PrenomTest1")
                .immatriculation("TESTIMMAT1")
                .numDom("02134567890")
                .numPortable("0689123456")
                .build();

        entityManager.persist(employe);
        entityManager.flush();

        log.info(employe.toString());

        Integer id = employe.getId();

        Optional<Employe> optionalEmploye = employeRepository.findById(id);

        Assertions.assertThat(optionalEmploye).isPresent();

        log.info(optionalEmploye.get().toString());
    }

    @Test
    public void test_deleteEmploye(){

        Employe employe = Employe.builder()
                .email("email@email.com")
                .nom("NomTest1")
                .prenom("PrenomTest1")
                .immatriculation("TESTIMMAT1")
                .numDom("02134567890")
                .numPortable("0689123456")
                .build();

        entityManager.persist(employe);
        entityManager.flush();

        log.info(employe.toString());

        Integer id = employe.getId();

        employeRepository.delete(employe);

        Employe e = entityManager.find(Employe.class, id);

        Assertions.assertThat(e).isNull();
    }


}
